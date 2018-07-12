package ru.job4j.multithreads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Parallel Search class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

@ThreadSafe
public class ParallelSearch {
    /**
     * Root when we will search a file.
     */
    private final String root;
    /**
     * Text what we will search in file.
     */
    private final String text;
    /**
     * File extension.
     */
    private final List<String> exts;
    /**
     * Флаг для блокирования потока начала поиска файлов.
     */
    @GuardedBy("this")
    private volatile boolean finish = false;

    /**
     * Files.
     */
    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();
    /**
     * Paths with needed extension.
     */
    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param root - root.
     * @param text - text.
     * @param exts - extension.
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * Init method.
     * Satreted two threads. One of them search paths, second search text in founding files.
     *
     * @throws InterruptedException - ie.
     */
    public void init() throws InterruptedException {
        Thread search = new Thread(() -> {
            synchronized (this) {
                Path startPath = Paths.get(root);
                try {
                    Files.walkFileTree(startPath, new SearchFileVisitor(exts, files));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.finish = true;
                notifyAll();
            }
        });
        Thread read = new Thread(() -> {
            synchronized (this) {
                while (!finish) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (String s : files) {
                    try {
                        List<String> temp = Files.readAllLines(Paths.get(s));
                        if (findText(temp, text)) {
                            paths.add(Paths.get(s).toString());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        search.start();
        read.start();
    }

    /**
     * Find text method.
     *
     * @param temp - list of dates when search files.
     * @param text - text.
     * @return return true if files has the same text.
     */
    private boolean findText(List<String> temp, String text) {
        for (String m : temp) {
            if (m.contains(text)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Result method.
     *
     * @return List of paths searching files.
     */
    synchronized List<String> result() {
        return this.paths;
    }
}
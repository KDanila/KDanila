package ru.job4j.multithreads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    volatile boolean finish = false;


    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() throws InterruptedException {
        Thread search = new Thread(() -> {
            Path startPath = Paths.get(root);
            String pattern = "regex:\\S+\\.txt";
            try {
                Files.walkFileTree(startPath, new SearchFileVisitor(pattern, files));
              //  finish = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread read = new Thread(() -> {
           // while (finish) {
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
            //}
        });
        search.start();
        search.join();
        read.start();
    }

    private boolean findText(List<String> temp, String text) {
        for (String m : temp) {
            if (m.contains(text)) {
                return true;
            }
        }
        return false;
    }

    synchronized List<String> result() {
        return this.paths;
    }

}
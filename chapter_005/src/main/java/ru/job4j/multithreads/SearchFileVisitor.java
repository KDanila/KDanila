package ru.job4j.multithreads;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Queue;

/**
 * SearchFileVisitor class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    /**
     * Matcher.
     */
    private List<String> exts;
    /**
     * Files.
     */
    private Queue<String> files;

    /**
     * Constructor.
     *
     * @param exts  - exts of files.
     * @param files - Queue of files.
     */
    public SearchFileVisitor(List<String> exts, Queue<String> files) {
        this.exts = exts;
        this.files = files;
    }

    /**
     * Visit file method.
     * Add files in queue if extension of file is the same.
     *
     * @param file  - path.
     * @param attrs - attrs.
     * @return FileVisitResult.
     * @throws IOException - io.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path name = file.getFileName();
        String n = name.toString();
        for (String s : this.exts) {
            if(n.endsWith(s)){
                this.files.add(file.toAbsolutePath().toString());
            }
        }

        return FileVisitResult.CONTINUE;
    }
}

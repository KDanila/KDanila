package ru.job4j.multithreads;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
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
    private PathMatcher matcher;
    /**
     * Files.
     */
    private Queue<String> files;

    /**
     * Constructor.
     *
     * @param matcher - matcher(regex).
     * @param files   - Queue of files.
     */
    public SearchFileVisitor(String matcher, Queue<String> files) {
        try {
            this.matcher = FileSystems.getDefault().getPathMatcher(matcher);
            this.files = files;
        } catch (IllegalArgumentException iae) {
            System.out.println("Illegal Argeument Exception");
        }
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
        if (matcher.matches(name)) {
            this.files.add(file.toAbsolutePath().toString());
        }
        return FileVisitResult.CONTINUE;
    }
}

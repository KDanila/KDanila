package ru.job4j.multithreads;

import net.jcip.annotations.GuardedBy;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.Queue;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;
    private Queue<String> files;

    public SearchFileVisitor(String matcher, Queue<String> files) {
        try {
            this.matcher = FileSystems.getDefault().getPathMatcher(matcher);
            this.files = files;
        } catch (IllegalArgumentException iae) {
            System.out.println("Illegal Argeument Exception");
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path name = file.getFileName();
        if (matcher.matches(name)) {
            this.files.add(file.toAbsolutePath().toString());
        }
        return FileVisitResult.CONTINUE;
    }
}

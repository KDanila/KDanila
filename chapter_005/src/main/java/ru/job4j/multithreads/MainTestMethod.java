package ru.job4j.multithreads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTestMethod {
    public static void main(String[] args) throws InterruptedException, IOException {
//        Path path = Paths.get("C:\\Projects\\KDanila\\chapter_005\\src\\main\\java\\ru\\job4j\\multithreads\\2.txt");
  //      String name = path.toString();

        ParallelSearch ps = new ParallelSearch("C:\\Projects\\KDanila\\chapter_005\\src\\main\\java\\ru\\job4j\\multithreads",
                "1",new ArrayList<>(Arrays.asList(".txt", ".java")));
        ps.init();
        Thread.sleep(1000);
        System.out.println(ps.result());
    }
}

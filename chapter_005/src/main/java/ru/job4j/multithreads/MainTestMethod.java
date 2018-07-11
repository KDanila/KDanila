/*package ru.job4j.multithreads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainTestMethod {
    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Paths.get("C:\\Projects\\KDanila\\chapter_005\\src\\main\\java\\ru\\job4j\\multithreads\\2.txt");
        String name = path.toString();
        List<String> temp = Files.readAllLines(Paths.get(name));
        System.out.println(temp);


        ParallelSearch ps = new ParallelSearch("C:\\Projects\\KDanila\\chapter_005\\src\\main\\java\\ru\\job4j\\multithreads",
                "1",new ArrayList<>(Arrays.asList(".exe", ".txt", ".java")));
        ps.init();
        Thread.sleep(1000);
        //ps.showAddedFiles();
        System.out.println(ps.result());
    }
}
*/
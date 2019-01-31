package ru.job4j.scanfilesystem;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenSearchShouldReturnCorrectFiles() {
        //   List<File> files(String parent, List<String> exts)
        initTestDirectoryWithFiles();
        String par = "C:\\test111";
        List<String> exts = new ArrayList<>();
        exts.add(".txt");
        exts.add(".jpeg");
        new Search().files(par,exts).forEach(System.out::println);
    }

    private void initTestDirectoryWithFiles()  {
        File initialDirectory = new File("\\test111");
        File firstDirectory = new File("\\test111\\first");
        File secondDirectory = new File("\\test111\\first\\second");
        File thirdDirectory = new File("\\test111\\third");
        File fourthDirectory = new File("\\test111\\fourth");
        File one = new File(initialDirectory.getAbsolutePath()+"\\one.txt");
        File two = new File(initialDirectory.getAbsolutePath()+"\\two.bmp");
        File three = new File(initialDirectory.getAbsolutePath()+"\\three.jpeg");
        File four = new File(firstDirectory.getAbsolutePath()+"\\four.jpeg");
        File five = new File(thirdDirectory.getAbsolutePath()+"\\five.jpeg");
        File six = new File(fourthDirectory.getAbsolutePath()+"\\six.doc");
        File seven = new File(fourthDirectory.getAbsolutePath()+"\\seven.doc");
        File eight = new File(secondDirectory.getAbsolutePath()+"\\eight.txt");
        initialDirectory.mkdir();
        firstDirectory.mkdir();
        secondDirectory.mkdir();
        thirdDirectory.mkdir();
        fourthDirectory.mkdir();
        try {
            one.createNewFile();
            two.createNewFile();
            three.createNewFile();
            four.createNewFile();
            five.createNewFile();
            six.createNewFile();
            seven.createNewFile();
            eight.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteTestDirectory() throws IOException {
        File initialDirectory = new File("\\test111");
        Files.walk(initialDirectory.toPath())
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

}
package ru.job4j.deleteabusewords;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class DropAbuseWords {
    /*
     *

    задан символьным поток. и символьный выходной поток. надо удалить все слова abuse.
    Важно все преобразования нужно делать в потоке. нельзя зачитать весь поток в память,
    удалить слова и потом записать. нужно все делать в потоке.

     */
//todo
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String buf;
            while ((buf = br.readLine()) != null) {
                System.out.println(Arrays.toString(buf.split("[`!@$*&^% ]")));
                Arrays.stream(buf.split("[`!@$*&^% ]"))
                        .peek(System.out::println)
                        .filter(x -> {
                            for (String s : abuse) {
                                if (s.equals(x)) {
                                    return true;
                                }
                            }
                            return false;
                        }).peek(System.out::println);
            }
        /*
                    .peek(System.out::println)
                    .filter(x -> {
                        for (String s : abuse) {
                            if (s.equals(x)) {
                                return true;
                            }
                        }
                        return false;
                    }).peek(System.out::println);*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Stream<String> abuseStream = Arrays.stream(abuse);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String result = Arrays
                .stream(abuse.toString().split("\\s+"))
                .distinct()
                .collect(Collectors.joining(" "));

        *//*String ss = bufferedReader.lines()
                .peek(System.out::println)
                .filter(x ->
                {
                    for (String s : abuse) {
                        if (x.equals(s))
                            System.out.println("true");{
                            return true;
                        }
                    }
                    System.out.println("false");
                    return false;
                })
                //.peek(System.out::println)
                .collect(Collectors.joining());
        *//*
        Stream<String> toCheck = Stream.concat(bufferedReader.lines(),
                abuseStream).
                .distinct();
        System.out.println(ss);*/
    }
}

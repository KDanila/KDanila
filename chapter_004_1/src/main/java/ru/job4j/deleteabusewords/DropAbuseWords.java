package ru.job4j.deleteabusewords;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DropAbuseWords {
    /*
     *

    задан символьным поток. и символьный выходной поток. надо удалить все слова abuse.
    Важно все преобразования нужно делать в потоке. нельзя зачитать весь поток в память,
    удалить слова и потом записать. нужно все делать в потоке.

     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String buf;
            Stream<String> lineStream;
            String outString;
            //можно ли сразу в поток записывать без outString?
            //И можно ли как-то через stream api нормально отфильтровать на предмет вхождения слов из массива abuse
            //без костыля в виде foreach в filter()
            while ((buf = br.readLine()) != null) {
                lineStream = Arrays.stream(buf.split("[`!@$*&^% ]"));
                outString = lineStream
                        .filter(x -> {
                            for (String s : abuse) {
                                if (s.equals(x)) {
                                    return false;
                                }
                            }
                            return true;
                        })
                        .collect(Collectors.joining(" "));
                out.write(outString.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
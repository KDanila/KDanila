package ru.job4j.deleteabusewords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class DropAbuseWords {
    /*
     *

    задан символьным поток. и символьный выходной поток. надо удалить все слова abuse.
    Важно все преобразования нужно делать в потоке. нельзя зачитать весь поток в память,
    удалить слова и потом записать. нужно все делать в потоке.
*/

    public void dropAbuses(final InputStream in, final OutputStream out, final String[] abuse) throws IOException {
        try (final PrintStream writer = new PrintStream(out);
             final BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            reader.lines()
                    .map(s -> Arrays.stream(abuse)
                            .reduce(s, (s1, s2) -> s1.replaceAll(s2, ""))
                    ).forEach(writer::println);
        }
    }
}
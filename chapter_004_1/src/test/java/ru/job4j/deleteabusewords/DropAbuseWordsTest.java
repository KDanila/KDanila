package ru.job4j.deleteabusewords;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class DropAbuseWordsTest {

    private final String[] abuseWords = {
            "one",
            "two",
            "three"
    };

    @Test
    public void whenFindAbuseWordsThenRemoveFromStream() {
        ByteArrayInputStream in = new ByteArrayInputStream("one two five seven".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DropAbuseWords dropAbuseWords = new DropAbuseWords();
        dropAbuseWords.dropAbuses(in, out, abuseWords);
        System.out.println(out);
    }

}
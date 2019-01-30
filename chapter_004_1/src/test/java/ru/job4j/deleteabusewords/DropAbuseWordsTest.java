package ru.job4j.deleteabusewords;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
        assertThat(out.toString(),is("five seven"));
    }

}
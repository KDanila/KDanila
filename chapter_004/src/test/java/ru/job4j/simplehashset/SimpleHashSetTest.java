package ru.job4j.simplehashset;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleHashSetTest {
    @Test
    public void whenHashSetAddReturnCorrectResults() {
        SimpleHashSet<String> shs = new SimpleHashSet<>();

        shs.add("0");
        shs.add("1");
        shs.add("2");
        shs.add("4");
        Iterator<Integer> iter = shs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
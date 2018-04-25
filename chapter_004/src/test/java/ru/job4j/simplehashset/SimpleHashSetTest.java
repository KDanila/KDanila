package ru.job4j.simplehashset;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleHashSetTest {
    @Test
    public void whenHashCodeReturnSameResults() {
        String s = "1111";
        String s1 = "1222111";
        String s2 = "111133";
        String s3 = "1111";
        String s4 = "111133";
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(6, 2);
        for (Object iii : arrayList) {
            System.out.println(iii);
        }

    }

}
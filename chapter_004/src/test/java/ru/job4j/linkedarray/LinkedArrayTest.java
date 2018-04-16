package ru.job4j.linkedarray;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LinkedArrayTest {

    @Test
    public void whenGettShoudRetutnCorectResult(){
        LinkedArray<String> test = new LinkedArray<>();
        test.add("1");
        test.add("2");
        test.add("3");
        String result = test.get(0);
        assertThat(result, is("1"));
    }

}
package ru.job4j.simplearray;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateContainerShouldReturnSameType(){
        SimpleArray<String> simple = new SimpleArray<>(10);
        simple.add("111");
        String result = simple.get(0);
        assertThat(result, is("111"));
    }
    @Test
    public void whenCreateContainerIntegerThanInteger(){
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        int result = simple.get(0);
        assertThat(result, is(1));
    }

}
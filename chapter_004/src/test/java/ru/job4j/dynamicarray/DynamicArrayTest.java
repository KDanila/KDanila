package ru.job4j.dynamicarray;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicArrayTest {

    @Test
    public void whenAddOneObjectShouldReturnTrue() {
        DynamicArray<String> da = new DynamicArray<>();
        da.add("1");
        String result = da.get(0);
        assertThat(result, is("1"));
    }

    @Test
    public void whenIncreasingDynamicArrayShouldIncreaseInTwoTimes() {
        DynamicArray<Integer> da = new DynamicArray<>(2);
        da.add(1);
        da.add(2);
        da.add(3);
        int result = da.getLengthOfArray();
        assertThat(result, is(4));
    }

    @Test
    public void whenIncreasingDynamicArrayShouldReturnCorrectData() {
        DynamicArray<Integer> da = new DynamicArray<>(2);
        da.add(1);
        da.add(2);
        da.add(3);
        assertThat(da.get(0), is(1));
        assertThat(da.get(1), is(2));
        assertThat(da.get(2), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateIteratorShouldReturnCorrectlyData() {
        DynamicArray<Integer> da = new DynamicArray<>(2);
        da.add(1);
        da.add(2);
        da.add(3);
        Iterator itr = da.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(2));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(3));
        assertThat(itr.hasNext(), is(false));
        itr.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorCreateAndAddElementShouldThrowError() {
        DynamicArray<Integer> da = new DynamicArray<>();
        da.add(1);
        da.add(2);
        da.add(3);
        Iterator itr = da.iterator();
        da.add(4);
        itr.next();
    }
}
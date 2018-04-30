package ru.job4j.dynamicarray;

import org.junit.Test;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * DynamicArrayTest - is like light ArrayList.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class DynamicArrayTest {
    /**
     * the First test.
     * testing add&get method.
     */
    @Test
    public void whenAddOneObjectShouldReturnTrue() {
        DynamicArray<String> da = new DynamicArray<>();
        da.add("1");
        String result = da.get(0);
        assertThat(result, is("1"));
    }

    /**
     * the Second test.
     * testing increasing array.
     */
    @Test
    public void whenIncreasingDynamicArrayShouldIncreaseInTwoTimes() {
        DynamicArray<Integer> da = new DynamicArray<>(2);
        da.add(1);
        da.add(2);
        da.add(3);
        int result = da.getLengthOfArray();
        assertThat(result, is(4));
    }

    /**
     * the Third test.
     * testing increasing array(return data).
     */
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

    /**
     * the Fourth test.
     * testing iterator and NoSuchElementException.
     */
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

    /**
     * the Fifth test.
     * testing ConcurrentModificationException.
     */
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

    /**
     * the Sixth test.
     * testing add method.
     */
    @Test
    public void whenAddDataWithPositionIndexShouldInputCorrectly() {
        DynamicArray<Integer> da = new DynamicArray<>();
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(0, 0);
        Iterator itr = da.iterator();
        assertThat(itr.next(), is(0));
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
    }

    /**
     * the Seventh test.
     * testing add method.
     */
    @Test
    public void whenSecondAddDataWithPositionIndexShouldInputCorrectly() {
        DynamicArray<Integer> da = new DynamicArray<>(128);
        da.add(1);
        da.add(1);
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(7, 777);
        Iterator itr = da.iterator();
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(777));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
    }
}
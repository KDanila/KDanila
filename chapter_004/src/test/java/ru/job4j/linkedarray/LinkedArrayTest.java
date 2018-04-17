package ru.job4j.linkedarray;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * LinkedArrayTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class LinkedArrayTest {
    /**
     * The First test.
     * testing add and get methods.
     */
    @Test
    public void whenGettShoudRetutnCorectResult() {
        LinkedArray<String> test = new LinkedArray<>();
        test.add("1");
        test.add("2");
        test.add("3");
        String result = test.get(0);
        assertThat(result, is("1"));
    }

    /**
     * The second method.
     * testing increasing method.
     */
    @Test
    public void whenIncreasingShouldExtendTwotimes() {
        LinkedArray<Integer> test = new LinkedArray<>(2);
        test.add(1);
        test.add(2);
        test.add(2);
        int expecting = test.getContainerLength();
        assertThat(expecting, is(4));
    }

    /**
     * the Third test.
     * testing increasing array(return data).
     */
    @Test
    public void whenIncreasingDynamicArrayShouldReturnCorrectData() {
        LinkedArray<Integer> la = new LinkedArray<>(2);
        la.add(1);
        la.add(2);
        la.add(3);
        assertThat(la.get(0), is(1));
        assertThat(la.get(1), is(2));
        assertThat(la.get(2), is(3));
    }

    /**
     * the Fourth test.
     * testing iterator and NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCreateIteratorShouldReturnCorrectlyData() {
        LinkedArray<Integer> la = new LinkedArray<>(2);
        la.add(1);
        la.add(2);
        la.add(3);
        Iterator itr = la.iterator();
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
        LinkedArray<Integer> la = new LinkedArray<>(2);
        la.add(1);
        la.add(2);
        la.add(3);
        Iterator itr = la.iterator();
        la.add(4);
        itr.next();
    }
}
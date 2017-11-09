package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortOfTwoSortedArraysTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortOfTwoSortedArraysTest {
    /**
     * Test {0, 0, 1, 2, 5, 5}+{1, 3, 5, 7, 9}----->{0, 0, 1, 1, 2, 3, 5, 5, 5, 7, 9}.
     */
    @Test
    public void whenTwoArraysThenOne() {
        SortOfTwoSortedArrays sortOfTwoSortedArrays = new SortOfTwoSortedArrays();
        int[] expected = {0, 0, 1, 1, 2, 3, 5, 5, 5, 7, 9};
        int[] first = {0, 0, 1, 2, 5, 5};
        int[] second = {1, 3, 5, 7, 9};
        int[] result = sortOfTwoSortedArrays.connection(first, second);
        assertThat(result, is(expected));
    }
    /**
     * Test {0, 0, 0, 0, 0, 0}+{1, 3, 5, 7, 9}----->{0, 0, 0, 0, 0, 0, 1, 3, 5, 7, 9}.
     */
    @Test
    public void whenOneArrayWithZeroThenOne() {
        SortOfTwoSortedArrays sortOfTwoSortedArrays = new SortOfTwoSortedArrays();
        int[] expected = {0, 0, 0, 0, 0, 0, 1, 3, 5, 7, 9};
        int[] first = {0, 0, 0, 0, 0, 0};
        int[] second = {1, 3, 5, 7, 9};
        int[] result = sortOfTwoSortedArrays.connection(first, second);
        assertThat(result, is(expected));
    }
    /**
     * Test {100, 100, 100, 100, 100, 100}+{1, 3, 5, 7, 9}----->{1, 3, 5, 7, 9, 100, 100, 100, 100, 100, 100}.
     */
    @Test
    public void whenOneArrayWithOneHundredThenOne() {
        SortOfTwoSortedArrays sortOfTwoSortedArrays = new SortOfTwoSortedArrays();
        int[] expected = {1, 3, 5, 7, 9, 100, 100, 100, 100, 100, 100};
        int[] first = {100, 100, 100, 100, 100, 100};
        int[] second = {1, 3, 5, 7, 9};
        int[] result = sortOfTwoSortedArrays.connection(first, second);
        assertThat(result, is(expected));
    }
}

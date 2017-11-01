package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Bubble Sort Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {
    /**
     * Test {9,0,6,7,5,8,4,3,2,1}----->{0,1,2,3,4,5,6,7,8,9}.
     */
    @Test
    public void whenTenNumbersNotSortedThenSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayToChange = {9, 0, 6, 7, 5, 8, 4, 3, 2, 1};
        int[] resultArray = bubbleSort.sort(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }

    /**
     * Test {9,0,6,7,5,8,0,0,0,0}----->{0,0,0,0,0,5,6,7,8,9}.
     */
    @Test
    public void whenTenNumbersWithFiveZeroNotSortedThenSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] expectedArray = {0, 0, 0, 0, 0, 5, 6, 7, 8, 9};
        int[] arrayToChange = {9, 0, 6, 7, 5, 8, 0, 0, 0, 0};
        int[] resultArray = bubbleSort.sort(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }
}

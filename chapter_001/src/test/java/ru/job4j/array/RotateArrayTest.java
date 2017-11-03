package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RotateArrayTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class RotateArrayTest {
    /**
     * Test.
     * 1 2 3           7 4 1
     * 4 5 6 ----->    8 5 2
     * 7 8 9           9 6 3
     */
    @Test
    public void whenThreeColumnsThenThreeColumns() {
        RotateArray rotateArray = new RotateArray();
        int[][] expectedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int[][] arrayToChange = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultArray = rotateArray.rotate(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }

    /**
     * Test.
     * 1 2             3 1
     *        ----->
     * 3 4             4 2
     */
    @Test
    public void whenTwoColumnsThenTwoColumns() {
        RotateArray rotateArray = new RotateArray();
        int[][] expectedArray = {{3, 1}, {4, 2}};
        int[][] arrayToChange = {{1, 2}, {3, 4}};
        int[][] resultArray = rotateArray.rotate(arrayToChange);
        assertThat(resultArray, is(expectedArray));
    }
}

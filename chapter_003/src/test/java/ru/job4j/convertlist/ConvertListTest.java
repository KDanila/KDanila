package ru.job4j.convertlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * ConvertList Test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class ConvertListTest {
    /**
     * First Test.
     */
    @Test
    public void toListWhenThreeXThree() {
        int[][] test = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        ArrayList<Integer> expecting = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        expecting.add(0);
        expecting.add(1);
        expecting.add(2);
        expecting.add(3);
        expecting.add(4);
        expecting.add(5);
        expecting.add(6);
        expecting.add(7);
        expecting.add(8);
        ArrayList<Integer> result = (ArrayList<Integer>) cl.toList(test);
        assertThat(result, is(expecting));
    }

    /**
     * Second Test.
     */
    @Test
    public void toListWhenTwoXFive() {
        int[][] test = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}};
        ArrayList<Integer> expecting = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        expecting.add(0);
        expecting.add(1);
        expecting.add(2);
        expecting.add(3);
        expecting.add(4);
        expecting.add(5);
        expecting.add(6);
        expecting.add(7);
        expecting.add(8);
        expecting.add(9);
        ArrayList<Integer> result = (ArrayList<Integer>) cl.toList(test);
        assertThat(result, is(expecting));
    }

    /**
     * Third Test.
     */
    @Test
    public void toListWhenOneXTen() {
        int[][] test = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}};
        ArrayList<Integer> expecting = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        expecting.add(0);
        expecting.add(1);
        expecting.add(2);
        expecting.add(3);
        expecting.add(4);
        expecting.add(5);
        expecting.add(6);
        expecting.add(7);
        expecting.add(8);
        expecting.add(9);
        ArrayList<Integer> result = (ArrayList<Integer>) cl.toList(test);
        assertThat(result, is(expecting));
    }

    /**
     * Fourth Test.
     */
    @Test
    public void toArrayOneToTenIntThreeRows() {
        int[][] result;
        ArrayList<Integer> test = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        result = cl.toArray(test, 3);
        int[][] expecting = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        assertThat(result, is(expecting));
    }

    /**
     * Fifth Test.
     */
    @Test
    public void toArrayOneToTenIntTwoRows() {
        int[][] result;
        ArrayList<Integer> test = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        result = cl.toArray(test, 2);
        int[][] expecting = {{0, 1}, {2, 3}};
        assertThat(result, is(expecting));
    }

    /**
     * Sixth Test.
     */
    @Test
    public void toArrayOneToFiveIntoThreeRows() {
        int[][] result;
        ArrayList<Integer> test = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        result = cl.toArray(test, 3);
        int[][] expecting = {{0, 1, 2}, {3, 4, 5}, {0, 0, 0}};
        assertThat(result, is(expecting));
    }

    /**
     * Seventh Test.
     */
    @Test
    public void toArrayOneToSixIntoThreeRows() {
        int[][] result;
        ArrayList<Integer> test = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        result = cl.toArray(test, 3);
        int[][] expecting = {{0, 1, 2}, {3, 4, 5}, {6, 0, 0}};
        assertThat(result, is(expecting));
    }

    /**
     * Eighth Test.
     */
    @Test
    public void toArrayOneToSixIntoOneRows() {
        int[][] result;
        ArrayList<Integer> test = new ArrayList<Integer>();
        ConvertList cl = new ConvertList();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        result = cl.toArray(test, 1);
        int[][] expecting = {{0}};
        assertThat(result, is(expecting));
    }

    /**
     * Ninth Test.
     */
    @Test
    public void toListOfIntegerFromIntMassive() {
        List<int[]> toChange = new ArrayList<int[]>();
        toChange.add(new int[]{1, 2});
        toChange.add(new int[]{3, 4, 5, 6});
        ConvertList cl = new ConvertList();
        List<Integer> expectedArray = new ArrayList<Integer>();
        expectedArray.add(1);
        expectedArray.add(2);
        expectedArray.add(3);
        expectedArray.add(4);
        expectedArray.add(5);
        expectedArray.add(6);
        List<Integer> result = cl.convert(toChange);
        assertThat(result, is(expectedArray));
    }

    /**
     * Tenth Test.
     */
    @Test
    public void toListOfIntegerFromIntMassiveTwo() {
        List<int[]> toChange = new ArrayList<int[]>();
        toChange.add(new int[]{1, 2});
        toChange.add(new int[]{3, 4, 5, 6});
        toChange.add(new int[]{3, 4, 5, 6});
        ConvertList cl = new ConvertList();
        List<Integer> expectedArray = new ArrayList<Integer>();
        expectedArray.add(1);
        expectedArray.add(2);
        expectedArray.add(3);
        expectedArray.add(4);
        expectedArray.add(5);
        expectedArray.add(6);
        expectedArray.add(3);
        expectedArray.add(4);
        expectedArray.add(5);
        expectedArray.add(6);
        List<Integer> result = cl.convert(toChange);
        assertThat(result, is(expectedArray));
    }

    /**
     * Eleventh Test.
     */
    @Test
    public void toListOfIntegerFromIntMassiveWithZero() {
        List<int[]> toChange = new ArrayList<int[]>();
        toChange.add(new int[]{0});
        toChange.add(new int[]{0, 0, 0, 0});
        ConvertList cl = new ConvertList();
        List<Integer> expectedArray = new ArrayList<Integer>();
        expectedArray.add(0);
        expectedArray.add(0);
        expectedArray.add(0);
        expectedArray.add(0);
        expectedArray.add(0);
        List<Integer> result = cl.convert(toChange);
        assertThat(result, is(expectedArray));
    }


}

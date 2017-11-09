package ru.job4j.array;

/**
 * SortOfTwoSortedArrays class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortOfTwoSortedArrays {
    /**
     * @param a - first array.
     * @param b - second array.
     * @return c - array after conection.
     */
    public int[] connection(int[] a, int[] b) {
        int x = 0;
        int y = 0;
        int summaryLength = (a.length + b.length);
        int[] addArray = new int[summaryLength];
        for (int i = 0; i < summaryLength; i++) {
            if (a[x] <= b[y]) {
                addArray[i] = a[x];
                if (x < a.length - 1) {
                    x++;
                } else {
                    a[x] = b[y];
                    if (y < b.length - 1) {
                        y++;
                    }
                }
            } else {
                addArray[i] = b[y];
                if (y < b.length - 1) {
                    y++;
                } else {
                    b[y] = a[x];
                    if (x < b.length - 1) {
                        x++;
                    }
                }
            }
        }
        return addArray;
    }
}

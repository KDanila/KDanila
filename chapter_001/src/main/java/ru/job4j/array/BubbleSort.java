package ru.job4j.array;

/**
 * BubbleSort class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * @param arrayToChange - array to invert.
     * @return sorted array.
     */
    public int[] sort(int[] arrayToChange) {
        int temp;
        for (int i = arrayToChange.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayToChange[j] > arrayToChange[j + 1]) {
                    temp = arrayToChange[j];
                    arrayToChange[j] = arrayToChange[j + 1];
                    arrayToChange[j + 1] = temp;
                }
            }
        }
        return arrayToChange;
    }
}


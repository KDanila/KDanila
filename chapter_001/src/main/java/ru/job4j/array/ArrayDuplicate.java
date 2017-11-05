package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * @param arrayToChange - array to delete all duplications.
     * @return sorted array.
     */
    public String[] remove(String[] arrayToChange) {
        int lengthOfArray = arrayToChange.length;
        String temp;
        //int counter = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            for (int j = 0; j < lengthOfArray; j++) {
                if (i != j && arrayToChange[i].equals(arrayToChange[j])) {
                    temp = arrayToChange[j];
                    arrayToChange[j] = arrayToChange[lengthOfArray - 1];
                    arrayToChange[lengthOfArray - 1] = temp;
                    lengthOfArray--;
                }
            }
        }
        return Arrays.copyOf(arrayToChange, lengthOfArray);
    }
}

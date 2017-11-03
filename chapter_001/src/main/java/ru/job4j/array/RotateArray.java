package ru.job4j.array;

import java.util.Arrays;

/**
 * RotateArray class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class RotateArray {
    /**
     * Invert arrays on 90 degrees.
     *
     * @param arrayToChange - array to rotate.
     * @return rotate array.
     */
    public int[][] rotate(int[][] arrayToChange) {
        int lengthOfLine;
        int lengthOfArray = arrayToChange[0].length;
        int[][] changedArray = new int[lengthOfArray][lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            changedArray[i] = Arrays.copyOf(arrayToChange[i], lengthOfArray);
        }
        for (int i = 0; i < lengthOfArray; i++) {
            lengthOfLine = lengthOfArray - 1 - 2 * i;
            for (int j = 0; j < lengthOfLine; j++) {
                changedArray[j][lengthOfLine - i] = arrayToChange[i][j];
                changedArray[lengthOfLine - i][lengthOfLine - j] = arrayToChange[j][lengthOfLine - i];
                changedArray[lengthOfLine - j][i] = arrayToChange[lengthOfLine - i][lengthOfLine - j];
                changedArray[i][j] = arrayToChange[lengthOfLine - j][i];
            }
        }
        return changedArray;
    }
}

package ru.job4j.array;

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
        //Как сократить 21-26. Есть же метод, который копирует значения ячеек?
        int[][] changedArray = new int[lengthOfArray][lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            for (int j = 0; j < lengthOfArray; j++) {
                changedArray[i][j] = arrayToChange[i][j];
            }
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

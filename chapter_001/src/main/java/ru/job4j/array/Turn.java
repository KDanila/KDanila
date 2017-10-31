package ru.job4j.array;

/**
 * Turn class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * @param intArrayToBack - array to invert.
     * @return resukt of invert.
     */
    public int[] back(int[] intArrayToBack) {
        int halfOfArray = intArrayToBack.length / 2;
        int temp;
        for (int i = 0; i < halfOfArray; i++) {
            temp = intArrayToBack[i];
            intArrayToBack[i] = intArrayToBack[intArrayToBack.length - i - 1];
            intArrayToBack[intArrayToBack.length - i - 1] = temp;
        }
        return intArrayToBack;
    }

}

package ru.job4j.max;

/**
 * Max.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Method max.
     *
     * @param first  number.
     * @param second number.
     * @return maximum of two numbers
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Method max.
     *
     * @param first  number.
     * @param second number.
     * @param third  number.
     * @return maximum of three numbers
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}

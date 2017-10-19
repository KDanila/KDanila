package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Method calc return factorial.
     *
     * @param n -number.
     * @return n!
     */
    public int calc(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }
}

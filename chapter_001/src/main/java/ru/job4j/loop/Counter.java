package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Counter {

    /**
     * Method retuns summ of even numbers.
     *
     * @param start  - first number
     * @param finish - last number
     * @return summ of even numbers
     */

    public int add(int start, int finish) {
        int total = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                total += i;
            }
        }
        return total;
    }
}

package ru.job4j.simplecollection.simplequeue.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenIterator class.
 * Return all even numbers fron int[].
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class EvenIterator implements Iterator {
    /**
     * numbers.
     */
    private final int[] numbers;

    /**
     * current position.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param numbers - int[];
     */
    EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * hasNext method.
     *
     * @return boolean - existing of next even number.
     */
    @Override
    public boolean hasNext() {
        int currentPosition = -1;
        for (int i = this.position; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                currentPosition = i;
                break;
            }
        }
        return currentPosition != -1;
    }

    /**
     * Next method.
     *
     * @return next even number.
     * @throws NoSuchElementException .
     */
    @Override
    public Integer next() throws NoSuchElementException {
        int nextInt = -1;
        while (hasNext()) {
            nextInt = this.numbers[this.position++];
            if (nextInt % 2 == 0) {
                break;
            }
        }
        if (nextInt == -1) {
            throw new NoSuchElementException();
        }
        return nextInt;
    }
}

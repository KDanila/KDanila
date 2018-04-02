package ru.job4j.eveniterator;

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
        for (int i = this.position; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Next method.
     *
     * @return next even number.
     * @throws NoSuchElementException .
     */
    @Override
    public Integer next() throws NoSuchElementException {
        for (int i = this.position; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                this.position++;
                return numbers[i];
            }
            this.position++;
        }
        if (this.numbers.length == 0 || this.position >= this.numbers.length) {
            throw new NoSuchElementException();
        }
        return -1;
    }
}

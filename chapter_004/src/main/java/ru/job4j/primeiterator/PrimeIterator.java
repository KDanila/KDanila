package ru.job4j.primeiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PrimeIterator class.
 * Return all even numbers fron int[].
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class PrimeIterator implements Iterator {

    /**
     * numbers.
     */
    private final int[] numbers;

    /**
     * current position.
     */
    private int position = 1;

    /**
     * Constructor.
     *
     * @param numbers - int[];
     */
    PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * hasNext method.
     *
     * @return boolean - existing of next prime number.
     */
    @Override
    public boolean hasNext() {
        for (int i = this.position; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Next method.
     *
     * @return next prime number.
     * @throws NoSuchElementException .
     */
    @Override
    public Integer next() throws NoSuchElementException {
        for (int i = this.position; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
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

    /**
     * Перебор делителей.
     *
     * @param number - income number.
     * @return boolean true-prime number, false - not prime.
     */
    private boolean isPrime(int number) {
        int possibleDivider = (int) Math.sqrt(number);
        for (int i = 2; i <= possibleDivider; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

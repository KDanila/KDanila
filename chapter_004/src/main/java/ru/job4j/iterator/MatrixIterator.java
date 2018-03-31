package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MatrixIterator class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class MatrixIterator implements Iterator<Integer> {
    /**
     * matrix.
     */
    private final int[][] matrix;

    /**
     * current position.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param matrix - int[][];
     */
    MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * hasNext method.
     *
     * @return boolean - existing of next position.
     */
    @Override
    public boolean hasNext() {
        int counter = 0;
        int matrixLength = matrix.length;
        for (int[] aMatrix : matrix) {
            counter += aMatrix.length;
        }
        return position < counter;
    }

    /**
     * Next method.
     *
     * @return current element.
     * @throws NoSuchElementException .
     */
    @Override
    public Integer next() throws NoSuchElementException {
        int counter = 0;
        int matrixLength = matrix.length;
        if (matrixLength == 0) {
            throw new NoSuchElementException();
        }
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                if (counter == this.position) {
                    this.position++;
                    return anAMatrix;
                }
                counter++;
            }
        }
        return -1;
    }
}

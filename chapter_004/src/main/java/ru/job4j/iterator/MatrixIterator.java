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
     * rows.
     */
    private int row = 0;
    /**
     * cells.
     */
    private int cell = 0;

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
        return !(row==matrix.length&&cell==0);
    }

    /**
     * Next method.
     *
     * @return current element.
     * @throws NoSuchElementException .
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (this.row == this.matrix.length&&this.cell==0) {
            throw new NoSuchElementException();
        }
        int nextElement = this.matrix[this.row][this.cell];
        if (this.cell == this.matrix[this.row].length - 1) {
            this.cell = 0;
            this.row++;
        } else {
            this.cell++;
        }
        return nextElement;
    }
}

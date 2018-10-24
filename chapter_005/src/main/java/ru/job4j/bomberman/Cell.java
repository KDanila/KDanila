package ru.job4j.bomberman;

/**
 * Cell class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Cell {
    /**
     * x.
     */
    private final int x;
    /**
     * y.
     */
    private final int y;

    /**
     * constructor.
     *
     * @param x - x.
     * @param y - y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter.
     *
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter.
     *
     * @return y.
     */

    public int getY() {
        return y;
    }
}

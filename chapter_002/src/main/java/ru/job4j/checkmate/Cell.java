package ru.job4j.checkmate;
/**
 * Cell class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Cell {
    /**
     * x - координата.
     */
    int x;
    /**
     * y - координата.
     */
    int y;

    /**
     * Конструктор.
     * @param x - оХ.
     * @param y - оУ.
     */
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Equals method.
     * @param cell - cell to equal.
     * @return boolean.
     */
    public boolean equals(Cell cell) {
        return cell.x == this.x && cell.y == this.y;
    }
}

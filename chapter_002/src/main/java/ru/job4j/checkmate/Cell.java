package ru.job4j.checkmate;
/**
 * Cell class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Cell {
    private int x;
    private int y;

    /**
     * Конструктор.
     * @param x - оХ.
     * @param y - оУ.
     */
    Cell(int x, int y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Equals method.
     * @param cell - cell to equal.
     * @return boolean.
     */
    public boolean equals(Cell cell) {
        return cell.getX() == this.getX() && cell.getY() == this.getY();
    }

    /**
     * x - координата.
     */
    public int getX() {
        return x;
    }

    public void setX(int x) throws ImposibleMoveException {
        if(x>=0&&x<8) {
            this.x = x;
        }else {
            throw new ImposibleMoveException();
        }
    }

    /**
     * y - координата.
     */
    public int getY() {
        return y;
    }

    public void setY(int y) throws ImposibleMoveException {
        if(y>=0&&y<8) {
            this.y = y;
        }else {
            throw new ImposibleMoveException();
        }
    }
}

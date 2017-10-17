package ru.job4j.condition;

/**
 * Point.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    /**
     * x and y.
     */
    private int x;
    /**
     * y.
     */
    private int y;

    /**
     *
     * @param x -Ox
     * @param y -Oy
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method X getter.
     *
     * @return x parameter
     */
    public int getX() {
        return this.x;
    }

    /**
     * Method Y getter.
     *
     * @return y parameter
     */
    public int getY() {
        return this.y;
    }

    /**
     * Method point checker.
     *
     * @param a -first number.
     * @param b -second number.
     * @return true if point belong function Y=aX+b, else false;
     */
    public boolean is(int a, int b) {
        return (getY() == (a * getX() + b)) ? true : false;
    }
}

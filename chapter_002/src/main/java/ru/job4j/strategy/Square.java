package ru.job4j.strategy;
/**
 * Square class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     *
     * @return string - рисунок.
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append(" ____\n|    |\n|____|\n ");
        return pic.toString();
    }
}

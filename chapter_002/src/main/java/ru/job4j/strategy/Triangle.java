package ru.job4j.strategy;
/**
 * Triangle class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    /**
     *
     * @return string - рисунок.
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("|\\\n| \\\n|__\\\n");
        return pic.toString();
    }
}

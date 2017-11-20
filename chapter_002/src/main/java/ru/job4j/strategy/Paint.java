package ru.job4j.strategy;
/**
 * Paint class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     *
     * @param shape - геометрическую форма объекта.
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}

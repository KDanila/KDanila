package ru.job4j.simpleset;

import java.util.Iterator;
/**
 * SimpleList interface.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public interface SimpleList<E>  {
    /**
     * get method.
     * @param index - index.
     * @return E - generic.
     */
    E get(int index);

    /**
     * Add method.
     * @param value - value.
     */
    void add(E value);

    /**
     * Iterator.
     * @return - iterator.
     */
    Iterator<E> iterator();
}

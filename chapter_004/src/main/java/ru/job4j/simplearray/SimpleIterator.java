package ru.job4j.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * SimpleIterator class.
 * Для прохода по одномерному массиву
 *
 * @param <E> - generic.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SimpleIterator<E> implements Iterator<E> {
    /**
     * size.
     */
    private int size;
    /**
     * objects array.
     */
    private Object[] objects;
    /**
     * Current possition.
     */
    private int cursor = 0;
    /**
     * Current E object.
     */
    private E toReturn = null;

    /**
     * Constructor.
     *
     * @param objects - array of objects.
     * @param size    - size of array.
     */
    public SimpleIterator(Object[] objects, int size) {
        this.size = size;
        this.objects = objects;
    }

    /**
     * hasNext method.
     *
     * @return - true if objects has next element.
     */
    @Override
    public boolean hasNext() {
      /*  return cursor != size && objects[cursor] != null;*/
        boolean isNext = false;
        for (int i = cursor; i < objects.length; i++) {
            if (objects[i] != null) {
                isNext = true;
            }
        }
        return isNext;
    }

    /**
     * Next method.
     *
     * @return E - generic.
     */
    @Override
    public E next() {
        int counter = 0;
        if (size == 0) {
            throw new NoSuchElementException();
        }
        for (Object object : objects) {
            if (counter == cursor) {
                toReturn = (E) objects[cursor++];
                break;
            }
            counter++;
        }
        return toReturn;
    }
}

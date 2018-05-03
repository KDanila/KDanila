package ru.job4j.simplecollection.simplequeue;

import ru.job4j.simplecollection.linkedarray.LinkedArray;

/**
 * SimpleQueue.
 *
 * @param <T> -generic.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SimpleQueue<T> {
    /**
     * data based on linked array.
     */
    private LinkedArray<T> data = new LinkedArray<>();

    /**
     * Poll method.
     *
     * @return T - generic.
     */

    public T poll() {
        T toReturn = data.get(0);
        data.takeFirst();
        return toReturn;
    }


    /**
     * Push Method.
     *
     * @param value - value.
     */
    public void push(T value) {
        this.data.add(value);
    }
}

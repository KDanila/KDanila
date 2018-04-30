package ru.job4j.simpleset;

import ru.job4j.linkedarray.LinkedArray;
//import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

/**
 * SimpleArray class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Array Objects.
     */
    //private SimpleList<E> objects = new SimpleArray<E>();
    private SimpleList<E> objects = new LinkedArray<>();

    /**
     * Add set method.
     *
     * @param e - e.
     */
    public void add(E e) {
        if (contains(e)) {
            objects.add(e);
        }
    }

    /**
     * Contains method.
     *
     * @param e - generic
     * @return true - if contains same data.
     */
    private boolean contains(E e) {
        boolean isContain = true;
        Iterator it = objects.iterator();
        while (it.hasNext()) {
            E temp = (E) it.next();
            if (temp.equals(e)) {
                isContain = false;
                break;
            }
        }
        return isContain;
    }

    /**
     * Iterator method.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return objects.iterator();
    }

}
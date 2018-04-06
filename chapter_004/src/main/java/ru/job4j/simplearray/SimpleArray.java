package ru.job4j.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */


public class SimpleArray<E> implements Iterable<E> {
    /**
     * objects - array of data.
     */
    private Object[] objects;
    /**
     * index - curent position.
     */
    private int index = 0;

    /**
     * Constructor.
     *
     * @param size - size of array.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Get position method.
     *
     * @param position - numberof position.
     * @return E - type.
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**
     * Add position method.
     *
     * @param value - add value.
     */
    public void add(E value) {
        this.objects[index++] = value;
    }

    /**
     * Set method. Change value of position.
     *
     * @param index - position to change.
     * @param model - value to set.
     */
    public void set(int index, E model) {
        this.objects[index] = model;
    }

    /**
     * Delete method.
     *
     * @param index - number of position to del.
     * @throws Exception - exception when array have no element
     */
    public void delete(int index) throws Exception {
        int objectLength = this.objects.length;
        if (objectLength != 0 && this.objects[index] != null) {
            this.objects[index] = null;
            System.arraycopy(this.objects, index + 1, this.objects, index, objectLength - 1 - index);
            this.index--;
        } else {
            throw new Exception("No element");
        }
    }

    /**
     * Iterator method.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        int size = this.objects.length;
        Object[] objects = this.objects;

        return new Iterator<E>() {
            private int cursor = 0;
            private E toReturn = null;

            @Override
            public boolean hasNext() {
                return cursor != size && objects[cursor] != null;
            }

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
        };
    }
}

package ru.job4j.linkedarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedArray - is like light LinkedList.
 *
 * @param <E> -generic.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class LinkedArray<E> implements Iterable<E> {
    /**
     * data of dynamic array.
     */
    private Object[] container;
    /**
     * Modification count.
     * Итератор должен реализовывать fail-fast поведение.
     */
    private int modificationCount = 0;
    /**
     * index.
     */
    private int index = 0;

    /**
     * Constructor.
     */
    public LinkedArray() {
        container = new Object[10];
    }

    /**
     * Overload constructor.
     *
     * @param size - size.
     */
    public LinkedArray(int size) {
        container = new Object[size];
    }

    /**
     * Get method.
     *
     * @param index - index.
     * @return E - generic.
     */
    public E get(int index) {
        E toReturn = null;
        if (index >= 0 && index < this.index) {
            toReturn = (E) ((Node) this.container[index]).getItem();
        }
        return toReturn;
    }

    /**
     * Add method.
     *
     * @param value - value.
     */
    public void add(E value) {

        if (this.index == 0) {
            container[index] = new Node<>(value, null, null);
        } else if (index == this.container.length) {
            this.container = increaseContainer();
            Node n = (Node<E>) container[index - 1];
            container[index] = new Node<>(value, n, null);
            n.setNext((Node) container[index]);
        } else {
            Node n = (Node<E>) container[index - 1];
            container[index] = new Node<>(value, (Node<E>) container[index - 1], null);
            n.setNext((Node) container[index]);
        }
        this.modificationCount++;
        this.index++;
    }

    /**
     * For queue realisation.
     * Change first element and shift all data from array.
     */
    public void takeFirst() {
        if (this.container[1] != null) {
            Node first = (Node) this.container[1];
            first.setPrev(null);
        }
        for (int i = 1; i < this.container.length; i++) {
            this.container[i - 1] = this.container[i];
            if (this.container[i] == null) {
                break;
            }
        }

    }

    /**
     * For test method. Return container length.
     *
     * @return ineger.
     */
    public int getContainerLength() {
        return this.container.length;
    }

    /**
     * Increase container method.
     *
     * @return object[].
     */
    private Object[] increaseContainer() {
        return Arrays.copyOf(this.container, this.container.length * 2);
    }

    /**
     * Getter modification count.
     *
     * @return int - modification count.
     */
    private int getModificationCount() {
        return modificationCount;
    }

    /**
     * Iterable interface implentation.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        int currentModCount = this.modificationCount;
        Object[] objects = this.container;
        return new Iterator<E>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return (objects[cursor] != null && cursor <= objects.length);
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (currentModCount != getModificationCount()) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (E) ((Node) objects[cursor++]).getItem();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
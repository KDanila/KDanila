package ru.job4j.dynamicarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicArray - is like light ArrayList.
 *
 * @param <E> -generic.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class DynamicArray<E> implements Iterable<E> {
    /**
     * data of dynamic array.
     */
    private Object[] container;
    /**
     * index.
     */
    private int index = 0;
    /**
     * Modification count.
     * Итератор должен реализовывать fail-fast поведение.
     */
    private int modificationCount = 0;

    /**
     * Constructor.
     */
    protected DynamicArray() {
        this.container = new Object[10];
    }

    /**
     * Overload constructor.
     *
     * @param size - size of array.
     */
    protected DynamicArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Add method.
     *
     * @param value - value.
     */
    public void add(E value) {
        if (this.container.length == index) {
            this.container = increaseArray();
        }
        this.container[index++] = value;
        this.modificationCount++;
    }

    /**
     * Overload add method. Coppied from ArrayList))).
     *
     * @param index - index position
     * @param value - value.
     * @throws IndexOutOfBoundsException - ioobe.
     */
    public void add(int index, E value) throws IndexOutOfBoundsException {
        if (index > this.index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        modificationCount++;
        int s = this.index;
        Object[] elementData = this.container;
        if (s == elementData.length) {
            elementData = increaseArray();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = value;
        this.index = s + 1;
    }

    /**
     * Increase array method.
     * Increasing in  two times by first capacity.
     *
     * @return - object[];
     */
    private Object[] increaseArray() {
        return Arrays.copyOf(this.container, this.container.length * 2);
    }

    /**
     * Gett method.
     *
     * @param index - index.
     * @return E - generic.
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Iterator.
     *
     * @return - Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        int currentModCount = this.modificationCount;
        Object[] objects = this.container;
        return new Iterator<E>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return objects[cursor] != null && cursor <= objects.length;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (currentModCount != getModificationCount()) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (E) objects[cursor++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    /**
     * Method to test class.
     *
     * @return -length of array.
     */
    protected int getLengthOfArray() {
        return this.container.length;
    }

    /**
     * Getter for modificationCount.
     *
     * @return - int.
     */
    private int getModificationCount() {
        return modificationCount;
    }
}


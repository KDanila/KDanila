package ru.job4j.linkedarray;


import ru.job4j.simpleset.SimpleList;

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

public class LinkedArray<E> implements SimpleList<E>, Iterable<E> {
    /**
     * Modification count.
     * Итератор должен реализовывать fail-fast поведение.
     */
    private int modificationCount = 0;

    /**
     * First node.
     */
    private Node<E> first;

    /**
     * Last node.
     */
    private Node<E> last;

    /**
     * Getter.
     *
     * @return int - index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Getter.
     *
     * @return int - size.
     */
    protected int getSize() {
        return this.index;
    }

    /**
     * Getter.
     *
     * @return modification count.
     */
    private int getModificationCount() {
        return modificationCount;
    }

    /**
     * index.
     */
    private int index = 0;

    /**
     * Get method.
     *
     * @param index - index.
     * @return E - generic.
     */
    public E get(int index) {
        E toReturn = null;
        int counter = 0;
        Node temp = first;
        while (counter <= index) {
            toReturn = (E) temp.getItem();
            temp = temp.getNext();
            counter++;
        }
        return toReturn;
    }

    /**
     * Add method.
     *
     * @param value - value.
     */
    public void add(E value) {
        Node<E> l = this.last;
        Node<E> temp = new Node<>(value, l, null);
        this.last = temp;
        if (this.first == null) {
            this.first = temp;

        } else {
            l.setNext(temp);
        }
        index++;
        this.modificationCount++;
    }

    /**
     * Method - for Queue realisation.
     */
    public void takeFirst() {
        if (this.first.getNext() != null) {
            this.first = this.first.getNext();
            this.first.setPrev(null);
        }
    }

    /**
     * Method - for Queue realisation.
     */
    public void takeLast() {
        if (this.last.getPrev() != null) {
            this.last = this.last.getPrev();
            this.last.setNext(null);
            index--;
        }
    }

    @Override
    public Iterator<E> iterator() {
        int currentModCount = this.modificationCount;
        return new Iterator<E>() {
            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                boolean isNext;
                if (currentNode == null) {
                    isNext = false;
                } else {
                    isNext = first == currentNode || currentNode.getPrev() != null;
                }
                return isNext;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                E toReturn;
                if (currentModCount != getModificationCount()) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    toReturn = currentNode.getItem();
                    currentNode = currentNode.getNext();
                } else {
                    throw new NoSuchElementException();
                }
                return toReturn;
            }
        };
    }
}
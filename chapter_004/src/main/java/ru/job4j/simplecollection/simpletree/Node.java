package ru.job4j.simplecollection.simpletree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Node<E extends Comparable<E>> {
    /**
     * List of children Node.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Value.
     */
    private final E value;

    /**
     * Constructor.
     *
     * @param value - value.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add method.
     *
     * @param child - Node.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Leaves method.
     *
     * @return List Node.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * eqValue method.
     * compare value state of two nodes.
     *
     * @param that - E.
     * @return true if value equals.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }


    /**
     * GetValue method.
     *
     * @return E value.
     */
    public E getValue() {
        return value;
    }
}
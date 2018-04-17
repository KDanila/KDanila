package ru.job4j.linkedarray;

/**
 * Node class.
 *
 * @param <E> -generic.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class Node<E> {
    /**
     * item.
     */
    private E item;
    /**
     * link on previous Node.
     */
    private Node<E> prev;
    /**
     * link on next Node.
     */
    private Node<E> next;

    /**
     * Constructor.
     *
     * @param item     - item.
     * @param previous - previous.
     * @param next     - next.
     */
    Node(E item, Node<E> previous, Node<E> next) {
        this.item = item;
        this.prev = previous;
        this.next = next;
    }

    /**
     * Getter.
     *
     * @return <E> item.
     */
    public E getItem() {
        return item;
    }
}

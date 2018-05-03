package ru.job4j.simplecollection.linkedarray;

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
    public Node(E item, Node<E> previous, Node<E> next) {
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

    /**
     * Setter.
     *
     * @param prev - previous.
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Setter.
     *
     * @param next - next.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Getter.
     *
     * @return Node - node.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Getter.
     *
     * @return previous.
     */
    public Node<E> getPrev() {
        return prev;
    }
}

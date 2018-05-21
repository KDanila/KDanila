package ru.job4j.simplecollection.binarysearchtree;

/**
 * Node class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Node<E> {
    /**
     * value.
     */
    private E value;
    /**
     * Left child.
     */
    private Node leftChild;
    /**
     * Right child.
     */
    private Node rightChild;

    /**
     * Constructor.
     *
     * @param value - value.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * GetValue method.
     *
     * @return E value.
     */
    public E getValue() {
        return value;
    }

    /**
     * Getter.
     *
     * @return left child.
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Setter.
     *
     * @param leftChild - left child.
     */
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Getter.
     *
     * @return right child.
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Setter.
     *
     * @param rightChild -right child.
     */
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}

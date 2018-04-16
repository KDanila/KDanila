package ru.job4j.linkedarray;

public class Node<E> {

    private E item;
    private Node<E> prev;
    private Node<E> next;

    Node(E item, Node<E> previous, Node<E> next) {
        this.item = item;
        this.prev = previous;
        this.next = next;
    }

    public E getItem() {
        return item;
    }
}

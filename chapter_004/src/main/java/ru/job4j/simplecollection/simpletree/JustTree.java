package ru.job4j.simplecollection.simpletree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class JustTree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    public JustTree(E root) {
        this.root = new Node<>(root);
    }

    public JustTree() {
    }

    @Override
    public boolean add(E parent, E child) {
        boolean isAdded = false;
        Node<E> childNode = new Node<>(child);
        if (this.root == null) {
            this.root = new Node<>(parent);
        }
        if (findBy(parent).isPresent()) {
            findBy(parent).get().add(childNode);
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}

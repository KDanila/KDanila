package ru.job4j.simplecollection.simpletree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * JustTree class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class JustTree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Tree root.
     */
    private Node<E> root;

    /**
     * Constructor.
     *
     * @param root - Node.
     */
    public JustTree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Constructor.
     */
    public JustTree() {
    }

    /**
     * Add method.
     *
     * @param parent - parent.
     * @param child  - child.
     * @return true if element was added.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean isAdded = false;
        Node<E> childNode = new Node<>(child);
        if (this.root == null) {
            this.root = new Node<>(parent);
        }
        Optional<Node<E>> oParent = findBy(parent);
        if (oParent.isPresent() && !findBy(child).isPresent()) {
            findBy(parent).get().add(childNode);
            isAdded = true;
        }
        return isAdded;
    }

    /**
     * Find by method.
     * Search Node by value.
     *
     * @param value - search key.
     * @return Optional Node.
     */
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

    /**
     * isBinary method.
     * checking tree and if tree is binary return true;
     *
     * @return true or false.
     */
    public boolean isBinary() {
/*        Queue<Node<E>> treeData = new LinkedList<>();
        treeData.offer(this.root);
        int counter;
        boolean isBinary = true;
        while (!treeData.isEmpty() && isBinary) {
            counter = 0;
            Node<E> el = treeData.poll();
            for (Node<E> child : el.leaves()) {
                treeData.offer(child);
                if (++counter > 2) {
                    isBinary = false;
                }
            }
        }
        return isBinary;*/

        int counter = 0;
        boolean isBinary = true;
        Iterator it = iterator();
        while (it.hasNext() && isBinary) {
            counter = 0;
            Node<E> currentNode = (Node<E>) it.next();
            for (Node<E> child : currentNode.leaves()) {
                counter++;
                if (counter > 2) {
                    isBinary = false;
                }
            }
        }
        return isBinary;
    }

    /**
     * Iterator method.
     *
     * @return itertaor.
     */
    @Override
    public Iterator iterator() {
        Queue<Node<E>> treeData = new LinkedList<>();
        Queue<Node<E>> allLeaves = new LinkedList<>();
        treeData.offer(this.root);
        allLeaves.offer(this.root);
        while (!treeData.isEmpty()) {
            Node<E> el = treeData.poll();
            for (Node<E> child : el.leaves()) {
                treeData.offer(child);
                allLeaves.offer(child);
            }
        }
        return allLeaves.iterator();
    }
}

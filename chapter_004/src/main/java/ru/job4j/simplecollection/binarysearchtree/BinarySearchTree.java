package ru.job4j.simplecollection.binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JustTree class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * root node.
     */
    private Node<E> root;

    /**
     * Add method.
     *
     * @param e - E.
     * @return if added - return true.
     */
    public boolean add(E e) {
        boolean isAdded = false;
        if (this.root == null) {
            this.root = new Node<>(e);
            isAdded = true;
        } else {
            Node<E> current = this.root;
            Node<E> parent;
            while (true) {
                parent = current;
                if (e.compareTo((E) current.getValue()) < 0) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(new Node(e));
                        isAdded = true;
                        break;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(new Node(e));
                        isAdded = true;
                        break;
                    }
                }
            }
        }

        return isAdded;
    }

    /**
     * Iterator method.
     *
     * @return iterator.
     */
    public Iterator<E> iterator() {
        List<E> treeData = new ArrayList<>();
        createArray(this.root, treeData);
        return treeData.iterator();
    }

    /**
     * Create array method.
     * Рекурсивный обходи массива.
     *
     * @param localRoot - local root.
     * @param data      - array.
     */
    private void createArray(Node<E> localRoot, List<E> data) {

        if (localRoot != null) {
            createArray(localRoot.getLeftChild(), data);
            data.add(localRoot.getValue());
            createArray(localRoot.getRightChild(), data);
        }
    }
}

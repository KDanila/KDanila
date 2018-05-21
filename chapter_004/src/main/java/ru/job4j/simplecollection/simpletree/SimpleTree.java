package ru.job4j.simplecollection.simpletree;

import java.util.Optional;

/**
 * SimpleTree interface.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return true if element eas added.
     */
    boolean add(E parent, E child);

    /**
     * Find by value method.
     *
     * @param value - search key.
     * @return Node.
     */
    Optional<Node<E>> findBy(E value);

}

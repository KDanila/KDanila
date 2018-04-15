package ru.job4j.generic;

/**
 * Store class.
 *
 * @param <T>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public interface Store<T extends Base> {
    /**
     * Add method.
     *
     * @param t - generic.
     */
    void add(T t);

    /**
     * Replace method.
     *
     * @param id    - string.
     * @param model - model.
     * @return -true-if replace.
     */
    boolean replace(String id, T model);

    /**
     * Delete methos.
     *
     * @param id -String.
     * @return true - if delete.
     * @throws Exception - exception.
     */
    boolean delete(String id) throws Exception;

    /**
     * Find t by id method.
     *
     * @param id - string id.
     * @return T.
     */
    T findById(String id);
}
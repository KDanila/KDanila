package ru.job4j.userservlet;

import java.util.Map;

/**
 * Store interface.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public interface Store<U> {
    /**
     * add method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean add(U user);

    /**
     * update method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean update(U user);

    /**
     * delete method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean delete(U user);

    /**
     * findAll method.
     *
     * @return Map.
     */
    Map<Integer, U> findAll();

    /**
     * findById method.
     *
     * @param id - int.
     * @return - User.
     */
    U findById(int id);
}

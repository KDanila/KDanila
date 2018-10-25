package ru.job4j.userservlet;

import java.util.Map;

/**
 * Store interface.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public interface Store {
    /**
     * add method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean add(User user);

    /**
     * update method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean update(User user);

    /**
     * delete method.
     *
     * @param user - user
     * @return boolean.
     */
    boolean delete(User user);

    /**
     * findAll method.
     *
     * @return Map.
     */
    Map<Integer, User> findAll();

    /**
     * findById method.
     *
     * @param id - int.
     * @return - User.
     */
    User findById(int id);
}

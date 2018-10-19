package ru.job4j.userservlet;

/**
 * Action interface.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
interface Action {
    /**
     * type method.
     *
     * @return - enum StoreAction.
     */
    StoreAction type();

    /**
     * Enumeration of user action.
     */
    enum StoreAction {
        /**
         * ADD, UPDATE, DELETE.
         */
        ADD, UPDATE, DELETE
    }
}
package ru.job4j.tracker;
/**
 * UserAction interface.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public interface UserAction {
    /**
     * @return - номер действия.
     */
    int key();
    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    void execute(Input input, Tracker tracker);
    /**
     * @return - Название действия.
     */
    String info();
}

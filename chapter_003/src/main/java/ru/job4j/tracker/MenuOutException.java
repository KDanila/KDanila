package ru.job4j.tracker;
/**
 * MenuOutException класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    /**
     *
     * @param msg - сообщение об ошибке.
     */
    MenuOutException(String msg) {
        super(msg);
    }
}

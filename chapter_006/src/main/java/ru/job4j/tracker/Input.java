package ru.job4j.tracker;

/**
 * Interface ввода данных.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * @param question - текст запроса.
     * @return String - полученный ответ от пользователя.
     */
    String ask(String question);

    /**
     *
     * @param question -текст запроса.
     * @param range - допустимые значения.
     * @return int - допустимое число.
     */
    int ask(String question, int[] range);

}

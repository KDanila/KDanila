package ru.job4j.tracker;

import java.util.Scanner;
/**
 * ConsoleInput класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * scanner ввода данных.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param question - текст запроса.
     * @return String - полученный ответ от пользователя.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}

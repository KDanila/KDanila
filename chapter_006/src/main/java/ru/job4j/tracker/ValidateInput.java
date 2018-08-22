package ru.job4j.tracker;
/**
 * ValidateInput класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
    /**
     *
     * @param question - текст запроса.
     * @param range - набор допустимых значений.
     * @return возвращает допустимое значение.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu: ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please return validate statement: ");
            }
        } while (invalid);
        return value;
    }
}

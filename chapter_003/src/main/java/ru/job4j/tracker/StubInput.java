package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * StubInput Class.
 * Create for autotesting.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * answers- example of user's answers.
     */
    private ArrayList<String> answers;
    /**
     * ints - набор допустимых значений.
     */
    private ArrayList<Integer> ints;
    /**
     * position- numver of position.
     */
    private int position = 0;

    /**
     * @param answers - user's answers.
     * @param ints - набор возможных значений.
     */
    public StubInput(ArrayList<String> answers, ArrayList<Integer> ints) {
        this.answers = answers;
        this.ints = ints;
    }

    /**
     * @param question - текст запроса.
     * @return answers- string.
     */
    @Override
    public String ask(String question) {
        return answers.get(position++);
    }

    /**
     *
     * @param question -текст запроса.
     * @param range - допустимые значения.
     * @return int - значение.
     */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        return Integer.parseInt(this.ask(question));
    }
}

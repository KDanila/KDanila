package ru.job4j.tracker;

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
    private String[] answers;
    /**
     * position- numver of position.
     */
    private int position = 0;

    /**
     * @param answers - user's answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * @param question - текст запроса.
     * @return anwers- string.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }
}

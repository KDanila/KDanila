package ru.job4j.queue;

/**
 * Task class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Task {
    /**
     * String - description.
     */
    private String desc;
    /**
     * int - priority(as lower as more priority).
     */
    private int priority;

    /**
     * Constructor.
     *
     * @param desc     - description.
     * @param priority - priority.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Getter.
     *
     * @return String - description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter.
     *
     * @return - int priority.
     */
    public int getPriority() {
        return priority;
    }
}
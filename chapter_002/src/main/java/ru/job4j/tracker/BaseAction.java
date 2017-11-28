package ru.job4j.tracker;

/**
 * BaseAction класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class BaseAction {
    /**
     * nameOfAction - название действия.
     */
    private String nameOfAction;

    /**
     * @return - номер действия.
     */
    abstract int key();

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    abstract void execute(Input input, Tracker tracker);

    /**
     * @return - Название действия.
     */
    String info() {
        return String.format("%s %s", this.key(), getNameOfAction());
    }

    /**
     * @param nameOfAction -setter.
     */
    public void setNameOfAction(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }

    /**
     * @return string - getter nameOfAction.
     */
    public String getNameOfAction() {
        return nameOfAction;
    }
}

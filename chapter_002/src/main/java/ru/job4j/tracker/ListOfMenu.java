package ru.job4j.tracker;

/**
 * ListOfMenu enum класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public enum ListOfMenu {
    /**
     * Варианты меню.
     */
    ADD, SHOW, EDIT, DELETE, FINDID, FINDNAME, EXIT;

    /**
     * @return Строку со значением варианта.
     */
    public String toString() {
        switch (this) {
            case ADD:
                return "0";
            case SHOW:
                return "1";
            case EDIT:
                return "2";
            case DELETE:
                return "3";
            case FINDID:
                return "4";
            case FINDNAME:
                return "5";
            case EXIT:
                return "6";
            default:
                return "Unspecified";
        }
    }
}

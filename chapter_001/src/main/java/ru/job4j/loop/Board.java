package ru.job4j.loop;

/**
 * Board class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * Method paint create desk heightXwidth with "X" or " ".
     *
     * @param height number.
     * @param width  number.
     * @return String with board.
     */
    public String paint(int height, int width) {
        StringBuilder text = new StringBuilder();
        boolean change = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                text.append((change) ? "x" : " ");
                change = !change;
            }
            text.append(System.getProperty("line.separator"));
        }
        return text.toString();
    }
}

package ru.job4j.loop;

/**
 * Paint class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Method create pyramid.
     *
     * @param height number.
     * @return String with pyromid.
     */
    public String piramid(int height) {
        StringBuilder pyromid = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 2 * height - 1; j > 0; j--) {
                pyromid.append((height - i >= j || height + i <= j) ? " " : "^");
            }
            pyromid.append(System.getProperty("line.separator"));
        }
        return pyromid.toString();
    }
}


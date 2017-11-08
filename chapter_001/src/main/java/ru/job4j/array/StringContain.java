package ru.job4j.array;

/**
 * StringContain class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StringContain {
    /**
     * @param origin -full string.
     * @param sub    - short string.
     * @return true or false(contain or don't)
     */
    boolean contains(String origin, String sub) {
        char[] originToChar = origin.toCharArray();
        char[] subToChar = sub.toCharArray();
        int counter = 0;
        for (int i = 0; i < originToChar.length; i++) {
            if (originToChar[i] == subToChar[0]) {
                for (int j = 0; j < subToChar.length; j++) {
                    if (originToChar[i + j] == subToChar[j]) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                    if (counter == subToChar.length) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}

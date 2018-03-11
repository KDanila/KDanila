package ru.job4j.comparator;

import java.util.Comparator;
/**
 * ListCompare class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class ListCompare implements Comparator<String> {
    /**
     * Compare method.
     * @param o1 - first String.
     * @param o2 - second String.
     * @return int -1,0,1.
     */
    @Override
    public int compare(String o1, String o2) {
        int toReturn = 0;
        int lengthO1 = o1.length();
        int lengthO2 = o2.length();
        char[] o1Char = o1.toCharArray();
        char[] o2Char = o2.toCharArray();
        if (lengthO1 == lengthO2) {
            for (int i = 0; i < lengthO1; i++) {
                if (o1Char[i] != o2Char[i]) {
                    toReturn = o1Char[i] - o2Char[i];
                }
            }
        } else {
            toReturn = lengthO1 - lengthO2;
        }
        if (toReturn > 0) {
            toReturn = 1;
        } else if (toReturn < 0) {
            toReturn = -1;
        }
        return toReturn;
    }
}

package ru.job4j.departmentsorting;

import java.util.Comparator;

import static java.lang.reflect.Array.getChar;

/**
 * CompareDepartmentsDown class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class CompareDepartmentsDown implements Comparator<String> {
    /**
     * Compare in opposite direction.
     *
     * @param o1 -String first.
     * @param o2 - String second.
     * @return int.
     */
    @Override
    public int compare(String o1, String o2) {
        char[] v1 = o1.toCharArray();
        char[] v2 = o2.toCharArray();
        int len1 = v1.length;
        int len2 = v2.length;
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (v1[k] != v2[k]) {
                return getChar(v2, k) - getChar(v1, k);
            }
        }
        return len1 - len2;
    }


}

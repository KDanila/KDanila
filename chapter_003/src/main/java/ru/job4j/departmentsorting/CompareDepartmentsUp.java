package ru.job4j.departmentsorting;

import java.util.Comparator;

/**
 * CompareDepartmentsUp class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class CompareDepartmentsUp implements Comparator<String> {
    /**
     * Compare in direct direction.
     *
     * @param o1 -String first.
     * @param o2 - String second.
     * @return int.
     */
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

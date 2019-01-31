package ru.job4j.departmentsorting;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * DepartmentSorting class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class DepartmentSorting {

    /**
     * Sorting department by several ways(compareStrategy).
     *
     * @param departments     - list of departments.
     * @param compareStrategy - compare strategy.
     * @return treeset.
     */
    TreeSet<String> sort(List<String> departments, Comparator<String> compareStrategy) {
        TreeSet<String> toReturn = new TreeSet<>(compareStrategy);
        String tempLine;
        int lastIndex;
        for (int i = 0; i < departments.size(); i++) {
            toReturn.add(departments.get(i));
            tempLine = departments.get(i);
            lastIndex = tempLine.lastIndexOf("\\");
            while (lastIndex != -1) {
                toReturn.add(tempLine.substring(0, lastIndex));
                tempLine = tempLine.substring(0, lastIndex);
                lastIndex = tempLine.lastIndexOf("\\");
            }
        }
        return toReturn;
    }
}

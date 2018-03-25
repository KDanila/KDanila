package ru.job4j.departmentsorting;

import java.util.Comparator;

public class CompareDepartmentsUp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

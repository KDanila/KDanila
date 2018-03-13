/*
package com; //Пишется полностью сайт.

import java.util.*;

public class Sorter {
    //Никакого смысла в пустом конструкторе нет, он создается по умолчанию. Перегрузки конструктора тут нет.
    public Sorter() {

    }

    Set<User> sort(List<User> list) {
        TreeSet<User> sortedList = new TreeSet<User>();
        sortedList.addAll(list);
        return sortedList;
        //        я бы написал без ссылки Collections.sort(list);
        //return new TreeSet<User>(users);
    }

    List<User> sortnamelength(List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth(List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        }; // Насколько я понял, если использовать лямбду весь этот метод сжимается до четырех строк.
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}
*/

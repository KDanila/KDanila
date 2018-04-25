package ru.job4j.simplehashset;

import ru.job4j.simplearray.SimpleArray;

import java.util.ArrayList;
import java.util.HashSet;

public class SimpleHashSet<E> {

    private int numberOfGroup;

    private SimpleArray<E> objects;

    SimpleHashSet() {
        this.numberOfGroup = 128;
        objects = new SimpleArray<>(128);
    }

    SimpleHashSet(int size) {
        this.numberOfGroup = size;
        objects = new SimpleArray<>(size);
    }

    public boolean add(E e) {
        int hash = e.hashCode()%numberOfGroup;
        //this.objects.add(hash,e);

        return false;
    }

    boolean contains(E e) {
        return false;
    }

    boolean remove(E e) {
        return false;
    }


}
/*
Напишите свою реализацию Set на базе хэш-таблицы. Реализуйте следующие методы:
1) boolean add (E e)
2) boolean contains (E e)
3) boolean remove (E e)
Ваша хэш-таблица должна базироваться на массиве.
Разрешение коллизий реализовывать не надо. Предусмотрите возможность роста
 хэш-таблицы при нехватке места для нового элемента.
 */
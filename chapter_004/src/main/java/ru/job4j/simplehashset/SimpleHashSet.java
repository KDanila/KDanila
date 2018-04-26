package ru.job4j.simplehashset;

import ru.job4j.dynamicarray.DynamicArray;

import java.util.Iterator;

public class SimpleHashSet<E> {
    /**
     * As standart here is 128 groups.
     */
    private int numberOfGroup;

    private DynamicArray<E> objects;

    private int size = 0;

    SimpleHashSet() {
        this.numberOfGroup = 128;
        objects = new DynamicArray<>(128);
        initializingObjectsArray(128);
    }

    SimpleHashSet(int size) {
        this.numberOfGroup = size;
        objects = new DynamicArray<>(size);
        initializingObjectsArray(size);

    }

    private void initializingObjectsArray(int size) {
        for (int i = 0; i <size; i++) {
            this.objects.add(null);
        }
    }

    public boolean add(E e) {
        //int hash = (this.size==0)?0:e.hashCode()%this.size;
        int hash = e.hashCode() % this.numberOfGroup;
        if (size / numberOfGroup > 0.75) {
            this.objects.increaseArray();
        }
        this.objects.add(hash, e);

        return false;
    }

    boolean contains(E e) {
        return false;
    }

    boolean remove(E e) {
        return false;
    }

    public Iterator iterator() {
        return this.objects.iterator();
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
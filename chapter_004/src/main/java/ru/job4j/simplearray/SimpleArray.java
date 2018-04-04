package ru.job4j.simplearray;

public class SimpleArray<E> {

    Object[] objects;
    int index = 0;

    SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int position) {
        return (E) this.objects[position];
    }
}

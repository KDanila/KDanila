package ru.job4j.simpleset;

import java.util.Iterator;

public interface SimpleList<E>  {
    E get(int index);
    void add(E value);
    Iterator<E> iterator();
}

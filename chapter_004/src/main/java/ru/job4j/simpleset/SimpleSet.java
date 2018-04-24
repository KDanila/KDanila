package ru.job4j.simpleset;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

/**
 * SimpleArray class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Array Objects.
     */
    private SimpleArray<E> objects = new SimpleArray<E>();

    /**
     * Add set method.
     *
     * @param e - e.
     */
    public void add(E e) {
        boolean isDouble = true;
        for (E object : objects) {
            if (object == e) {
                isDouble = false;
            }
        }
        if (isDouble) {
            objects.add(e);
        }
    }

    /**
     * Iterator method.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return objects.iterator();
    }

}
/*
Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать void add(E e)
 и реализовывать Iterable<E>.
Коллекция не должна хранить дубликаты.
Set - внутри для хранения данных использует обычные массивы.


Код будет идентичным, как и в SimpleList(Это код из задания реализации списка
на массиве).
как можно за счет композиции сократить количества кода?
Здесь нужно использовать SimpleList в реализации SimpleSet.
 */
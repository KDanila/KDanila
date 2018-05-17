package ru.job4j.simplecollection.simpletree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

}
/*
метод add - Должен находить элемент parent в дереве и добавлять в него дочерний элемент.

node.children.add(child);

Для поиска элементов в дереве надо использовать методы findBy - Он уже реализован.

В дереве не могут быть дубликатов, т.е. никакие узлы в дереве не должны иметь двух одинаковых дочерних узлов.
Обязательно реализуйте итератор.


Давайте рассмотрим пример реализации метода findBy

В качестве базового алгоритма мы будет использовать алгоритм поиска в ширину.

 */
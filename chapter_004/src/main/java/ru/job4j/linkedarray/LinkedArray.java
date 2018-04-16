package ru.job4j.linkedarray;


import java.util.Arrays;
import java.util.Iterator;

public class LinkedArray<E> implements Iterator<E> {
    private Object[] container;

    private int index = 0;

    LinkedArray() {
        container = new Object[10];
    }

    LinkedArray(int size) {
        container = new Object[size];
    }

    public E get(int index) {
        E toReturn = null;
        if (index >= 0 && index < this.index) {
            toReturn = (E) ((Node) this.container[0]).getItem();
        }
        return toReturn;
    }

    public void add(E value) {
        if (this.index == 0) {
            container[index] = new Node<E>(value, null, null);
        } else if (index == this.container.length) {
            this.container = increaseContainer();
        } else {
            container[index] = new Node<E>(value, (Node<E>) container[index - 1], null);
        }
        this.index++;
    }

    private Object[] increaseContainer() {
        {
            return Arrays.copyOf(this.container, this.container.length * 2);
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
/*
Необходимо создать динамический контейнер с методами:

1) add(E value);

2) E get(int index);

3) реализовать интерфейс Iterable<E>.

Внутри контейнер должен базироваться на связанном списке(Node<E> node). Использовать стандартные коллекции JDK
(ArrayList, LinkedList и т.д.) запрещено. Контейнер должен быть динамическим, т.е. увеличиваться по мере добавления
элементов.

Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась
структурному изменению, итератор должен кидать ConcurrentModificationException.
Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию
 должна инкрементировать этот счетчик. В свою очередь итератор запоминает значение этого счетчика на момент своего
 создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля
 modCount, если они отличаются, то генерируется исключение.
 */
package ru.job4j.dynamicarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container;

    private int index = 0;

    private int modificationCount = 0;

    public DynamicArray() {
        this.container = new Object[10];
    }

    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        if (this.container.length == index) {
            this.container = increaseArray();
        }
        this.container[index++] = value;
        this.modificationCount++;
    }

    private Object[] increaseArray() {
        return Arrays.copyOf(this.container, this.container.length * 2);
    }

    public E get(int index) {
        return (E) this.container[index];
    }

    //TODO
    @Override
    public Iterator<E> iterator() {
        int currentModCount = this.modificationCount;
        Object[] objects = this.container;
        return new Iterator<E>() {
            private int cursor = 0;


            @Override
            public boolean hasNext() {
                return (objects[cursor]!=null&&objects.length != 0 && cursor <= objects.length);
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if(currentModCount!=getModificationCount()){
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (E) objects[cursor++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public int getLengthOfArray() {
        return this.container.length;
    }

    public int getModificationCount() {
        return modificationCount;
    }
}


/*
Необходимо создать динамический контейнер с методами:

1) add(E value);

2) E get(int index);

3) реализовать интерфейс Iterable<E>.

Внутри контейнер должен базироваться на массиве (Object[] container). Использовать стандартные коллекции JDK
(ArrayList, LinkedList и т.д.) запрещено. Контейнер должен быть динамическим, т.е. при полном заполнении увеличиваться.

Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась
структурному изменению, итератор должен кидать ConcurrentModificationException.
Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует
коллекцию должна инкрементировать этот счетчик. В свою очередь итератор запоминает значение этого счетчика на момент
своего создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение, с текущим значением
поля modCount, если они отличаются, то генерируется исключение.  */
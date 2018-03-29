package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {

    private final int[][] matrix;

    int position;

    MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return 0;
    }
}
/*
Необходимо создать итератор для двухмерного массива.

int[][] value = {
   {1, 2}
   {3, 4}
};

метод next = должен вернуть последовательно 1, 2, 3, 4.

Старайтесь написать универсальное решение, чтобы оно не было
 жестко ориентировано на тестовый пример.
И хотя в примере указана квадратная матрица, программа должна
 корректно обрабатывать и jagged array тоже.
Пример jagged array - {{1},{2, 3, 4, 5,},{6, 7},
{8, 9, 10, 11, 12, 13, 14}}
Не используйте в данном задании коллекции из JDK,
 вспомогательные массивы и т.д.
Постарайтесь реализовать последовательным проходом по массиву.
 */
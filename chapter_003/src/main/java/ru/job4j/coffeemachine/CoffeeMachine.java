package ru.job4j.coffeemachine;

import java.util.Arrays;

/**
 * CoffeeMachine class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class CoffeeMachine {
    /**
     * Возвращает int[] с наименьшим количеством монет для сдачи(при условии, что любого номинала неограничено много.
     *
     * @param value - внесенная сумма.
     * @param price - цена продукта.
     * @return - int[] changes.
     */
    int[] changes(int value, int price) {
        int change = (value - price > 0) ? (value - price) : 0;
        int[] temp = new int[change / 10 + 3];
        int[] coinArray = {1, 2, 5, 10};
        int numOfCoin = coinArray.length;
        int i = 0;
        int[] toReturn;
        while (change != 0) {
            if (coinArray[numOfCoin - 1] <= change) {
                temp[i++] = coinArray[numOfCoin - 1];
                change -= coinArray[numOfCoin - 1];
            } else {
                numOfCoin--;
            }
        }
        toReturn = Arrays.copyOf(temp, i);
        return toReturn;
    }
}

/*
Задание такое.
Надо реализовать метод выдачи сдачи для автомата.
int[] changes(int value, int price)
value = купюра. 50 100 и тд.
price = цена кофе
в автомате монеты наминалом 1 2 5 10
Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу автомат должен дать 15 рублей
Алгоритм должен вернуть наименьшее количество монет.
Метод вернет массив {10, 5} = 15 рублей
создать задачу залить в репозитори добавить ссылку
 */
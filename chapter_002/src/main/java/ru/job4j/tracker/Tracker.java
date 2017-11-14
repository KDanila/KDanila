package main.java.ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public static final Random RN = new Random(1000);

    /*
    1. Метод public Item add(Item) добавляет заявку, переданную в аргументах в массив заявок this.items;
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /*
    2. Метод public void update(Item) должен заменить ячейку в массиве this.items. Для этого необходимо найти
     ячейку в массиве по id (id у Item можно получить с помощью метода getId). Обязательно принимать один
     параметр Item, а не список полей;
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                this.items[i] = item;
            }
        }
    }

    /* Метод public void delete(Item) должен удалить ячейку в массиве this.items. Для этого необходимо найти
     ячейку в массиве по id. После этого присвоить ей null, либо сместить все значения справа от удаляемого
     элемента - на одну ячейку влево с помощью System.arrayCopy();*/
    public void delete(Item item) {
        String id = item.getId();
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i, items, i + 1, position - i - 1);
                items[position - 1] = null;
                position--;
            }
        }

    }

    /*
    4. Метод public Item[] findAll() возвращает копию массива this.items без null элементов;
     */
    public Item[] findAll() {
        Item[] toReturn = new Item[this.position];
        for (int i = 0; i != position; i++) {
            toReturn[i] = this.items[i];
        }
        return toReturn;
    }

    /*
    5. Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items,
    сравнивая name (используя метод getName класса Item) с аргументом метода String key. Элементы, у
    которых совпадает name, копирует в результирующий массив и возвращает его;
     */
    public Item findByName(String key) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /*
    6. Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
    сравнивая id с аргументом String id и возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(String id) {

        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Генерация идет простым добавлением единицы каждой новой заявки. Сделал так для избежания возможного
     * совпадения числа при генерации случайным образом.
     *
     * @return Уникальный ключ.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
    /*






     */


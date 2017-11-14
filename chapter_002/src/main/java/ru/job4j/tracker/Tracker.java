package main.java.ru.job4j.tracker;

import java.util.Random;

/**
 * Tracker класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
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
     * Переменная для генерации уникального id.
     */
    public static final Random RN = new Random(1000);

    /**
     * Метод public Item add(Item) добавляет заявку, переданную в аргументах в массив заявок this.items.
     *
     * @param item
     * @return item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;

        return item;
    }

    /**
     * Метод public void update(Item) должен заменить ячейку в массиве this.items.
     * Для этого находит ячейку в массиве по id.
     *
     * @param item - текущая заявка.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                this.items[i] = item;
            }
        }
    }


    /**
     * Метод public void delete(Item) должен удалить ячейку в массиве this.items.
     * Для этого находит ячейку в массиве по id и после этого присвавивает ей null и смещает
     * все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy().
     *
     * @param item
     */
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

    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов.
     *
     * @return массив item без пустых элементов
     */
    public Item[] findAll() {
        Item[] toReturn = new Item[this.position];
        for (int i = 0; i != position; i++) {
            toReturn[i] = this.items[i];
        }
        return toReturn;
    }

    /**
     * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items.
     * Происходит сравнение name (используя метод getName класса Item) с аргументом метода String key.
     * Если Item не найден - возвращает null.
     *
     * @param key - имя заявки
     * @return item - заявка
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

    /**
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items.
     * Просиходит сравнение id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     *
     * @param id - требуемый id.
     * @return item - искомая завяка.
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
     *
     * @return Уникальный ключ.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
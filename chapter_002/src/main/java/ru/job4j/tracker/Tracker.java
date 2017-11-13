package main.java.ru.job4j.tracker;

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

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public void update(Item item) {

    }

    public void delete(Item item) {

    }

    public Item[] findAll(){
        return null;
    }

    public Item[] findByName(String key){
        return null;
    }

    public Item findById(String id){
        return null;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Генерация идет простым добавлением единицы каждой новой заявки. Сделал так для избежания возможного
     * совпадения числа при генерации случайным образом.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        String id = String.valueOf( Integer.parseInt(Item.getId()+1));
        return id;
    }
}
    /*
1. Метод public Item add(Item) добавляет заявку, переданную в аргументах в массив заявок this.items;
2. Метод public void update(Item) должен заменить ячейку в массиве this.items. Для этого необходимо найти
 ячейку в массиве по id (id у Item можно получить с помощью метода getId). Обязательно принимать один
 параметр Item, а не список полей;
3. Метод public void delete(Item) должен удалить ячейку в массиве this.items. Для этого необходимо найти
 ячейку в массиве по id. После этого присвоить ей null, либо сместить все значения справа от удаляемого
 элемента - на одну ячейку влево с помощью System.arrayCopy();
4. Метод public Item[] findAll() возвращает копию массива this.items без null элементов;
5. Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items,
сравнивая name (используя метод getName класса Item) с аргументом метода String key. Элементы, у
которых совпадает name, копирует в результирующий массив и возвращает его;
6. Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
сравнивая id с аргументом String id и возвращает найденный Item. Если Item не найден - возвращает null.
     */


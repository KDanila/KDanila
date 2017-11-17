package ru.job4j.tracker;

/**
 * StartUI класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Input.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ListOfMenu.ADD.toString().equals(answer)) {
                this.createItem();
            } else if (ListOfMenu.SHOW.toString().equals(answer)) {
                this.findAll();
            } else if (ListOfMenu.EDIT.toString().equals(answer)) {
                this.edit();
            } else if (ListOfMenu.DELETE.toString().equals(answer)) {
                this.delete();
            } else if (ListOfMenu.FINDID.toString().equals(answer)) {
                this.findById();
            } else if (ListOfMenu.FINDNAME.toString().equals(answer)) {
                this.findByName();
            } else if (ListOfMenu.EXIT.toString().equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Поиск по имени.
     */
    private void findByName() {
        String name = this.input.ask("Введите имя искомой заявки: ");
        Item item = this.tracker.findByName(name);
        System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription() + " id: " + item.getId());
    }

    /**
     * Поиск по id.
     */
    private void findById() {
        String id = this.input.ask("Введите номер id искомой заявки: ");
        Item item = this.tracker.findById(id);
        System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription() + " id: " + item.getId());
    }

    /**
     * Удаление заявки.
     */
    private void delete() {
        String id = this.input.ask("Введите номер id удаляемой заявки: ");
        Item item = tracker.findById(id);
        this.tracker.delete(item);
    }

    /**
     * Редактирование заявки.
     */
    private void edit() {
        String id = this.input.ask("Введите номер id редактируемой заявки: ");
        Item item = tracker.findById(id);
        item.setName(this.input.ask("Введите новое имя заявки :"));
        item.setDescription(this.input.ask("Введите новое описание заявки :"));
        this.tracker.update(item);
    }

    /**
     * Метод отображает все заявки.
     */
    private void findAll() {
        Item[] items = this.tracker.findAll();
        System.out.println("------------ Заявки --------------");
        for (Item i : items) {

            System.out.println("Имя: " + i.getName() + " Описание: " + i.getDescription() + " id: " + i.getId());

        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 1);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Отображает загрузочное меню.
     */
    private void showMenu() {
        System.out.println("Меню. \n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
        );
    }

    /**
     * Запускт программы.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}




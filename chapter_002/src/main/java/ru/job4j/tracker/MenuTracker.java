package ru.job4j.tracker;

/**
 * Menu tracker класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    /**
     * input - массив данных ввода.
     */
    private Input input;
    /**
     * tracker - массив заявок.
     */
    private Tracker tracker;
    /**
     * actions - массив возможных действий.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     *
     * @param input   - данные ввода.
     * @param tracker - массив возможных действий.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполнение массива действий.
     */
    public void fillAction() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItem();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemByID();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new EndAction();
    }

    /**
     * Показать все действия.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * @param key - номер действия.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс для добавления заявок.
     */
    private class AddItem implements UserAction {
        /**
         * @return - номер действия.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * @param input   - вводной массив ответов.
         * @param tracker - массив заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter task's name: ");
            String desc = input.ask("Enter task's desc: ");
            tracker.add(new Item(name, desc, 1));
        }

        /**
         * @return - Название действия.
         */
        @Override
        public String info() {
            return String.format("%s %s", this.key(), "Add the new item. ");
        }
    }

    /**
     * Класс по отображению всех заявок в базе.
     */
    private static class ShowItem implements UserAction {

        /**
         * @return - номер действия.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * @param input   - вводной массив ответов.
         * @param tracker - массив заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item i : tracker.findAll()) {
                System.out.println("Имя: " + i.getName() + " Описание: " + i.getDescription() + " id: " + i.getId());

            }
        }

        /**
         * @return - Название действия.
         */
        @Override
        public String info() {
            return String.format("%s %s", this.key(), "Show all items. ");
        }
    }
}

/**
 * Класс для редактирования заявки.
 */
class EditItem implements UserAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return 2;
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id редактируемой заявки: ");
        Item item = tracker.findById(id);
        item.setName(input.ask("Введите новое имя заявки :"));
        item.setDescription(input.ask("Введите новое описание заявки :"));
        tracker.update(item);
    }

    /**
     * @return - Название действия.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), "Edit items. ");
    }
}

/**
 * Класс для удаления заявки.
 */
class DeleteItem implements UserAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return 3;
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id удаляемой заявки: ");
        Item item = tracker.findById(id);
        tracker.delete(item);
    }

    /**
     * @return - Название действия.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), "Delete item. ");
    }
}

/**
 * Класс для поиска заявки по id.
 */
class FindItemByID implements UserAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return 4;
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id искомой заявки: ");
        Item item = tracker.findById(id);
        System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription() + " id: " + item.getId());

    }

    /**
     * @return - Название действия.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), "Find item by ID. ");
    }
}

/**
 * Класс для поиска заявки по имени.
 */
class FindItemByName implements UserAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return 5;
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя искомой заявки: ");
        Item item = tracker.findByName(name);
        System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription() + " id: " + item.getId());
    }

    /**
     * @return - Название действия.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), "Find item by name. ");
    }
}

/**
 * Класс для выхода из программы.
 */
class EndAction implements UserAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return 6;
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {

    }

    /**
     * @return - Название действия.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), "Exit Program. ");
    }
}

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
     * Позиция действия в заявке.
     */
    private int position = 0;
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
    private BaseAction[] actions = new BaseAction[7];

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
        addAction(new AddItem(), "Add the new item.");
        addAction(new ShowItem(), "Show all item.");
        addAction(new EditItem(), "Edit items.");
        addAction(new DeleteItem(), "Delete item.");
        addAction(new FindItemByID(), "Find item by ID.");
        addAction(new FindItemByName(), "Find item by name.");
        addAction(new EndAction(), "Exit");
    }

    /**
     * @param action - действие пользователя.
     * @param name   - название.
     */
    public void addAction(BaseAction action, String name) {
        action.setNameOfAction(name);
        this.actions[getPosition()] = action;
        setPosition(getPosition() + 1);
    }

    /**
     * Показать все действия.
     */
    public void show() {
        for (BaseAction action : this.actions) {
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
     * @return - возвращаем массив возможных значений.
     */
    public int[] getPossibleVariety() {
        int[] intToReturn = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            intToReturn[i] = i;
        }
        return intToReturn;
    }

    /**
     * @return - getter.
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @param position - setter.
     */
    public void setPosition(int position) {
        this.position = position;
    }
}

/**
 * Класс реализующий добавления заявки.
 */
class AddItem extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.ADD.toInteger();
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter task's name: ");
        String desc = input.ask("Enter task's desc: ");
        tracker.add(new Item(name, desc));
    }
}

/**
 * Класс реализующий показ всех заявок.
 */
class ShowItem extends BaseAction {

    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.SHOW.toInteger();
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
}

/**
 * Класс для редактирования заявки.
 */
class EditItem extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.EDIT.toInteger();
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id редактируемой заявки: ");
        Item item = tracker.findById(Integer.valueOf(id));
        item.setName(input.ask("Введите новое имя заявки :"));
        item.setDescription(input.ask("Введите новое описание заявки :"));
        tracker.update(item);
    }

}

/**
 * Класс для удаления заявки.
 */
class DeleteItem extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.DELETE.toInteger();
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id удаляемой заявки: ");
        Item item = tracker.findById(Integer.valueOf(id));
        tracker.delete(item);
    }
}

/**
 * Класс для поиска заявки по id.
 */
class FindItemByID extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.FINDID.toInteger();
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите номер id искомой заявки: ");
        Item item = tracker.findById(Integer.valueOf(id));
        System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription() + " id: " + item.getId());

    }
}

/**
 * Класс для поиска заявки по имени.
 */
class FindItemByName extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.FINDNAME.toInteger();
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
}

/**
 * Класс для выхода из программы.
 */
class EndAction extends BaseAction {
    /**
     * @return - номер действия.
     */
    @Override
    public int key() {
        return ListOfMenu.EXIT.toInteger();
    }

    /**
     * @param input   - вводной массив ответов.
     * @param tracker - массив заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {

    }
}

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
        Tracker tracker = this.tracker;
        tracker.connectingToDB();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        int key;
        do {
            menu.show();
            key = input.ask("Select: ", menu.getPossibleVariety());
            menu.select(key);
        } while (key != menu.getPossibleVariety().length - 1);
    }

    /**
     * Запускт программы.
     *
     * @param args - args.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}




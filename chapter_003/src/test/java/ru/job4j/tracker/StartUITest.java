package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test StartUI Test Class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    /**
     * Тест add item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        ArrayList<String> in = new ArrayList<>();
        in.add("0");
        in.add("test name");
        in.add("desc");
        in.add("6");
        Input input = new StubInput(in, null);   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    /**
     * Test update method.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        ArrayList<String> in = new ArrayList<>();
        in.add("2");
        in.add(item.getId());
        in.add("test name");
        in.add("desc");
        in.add("6");
        Input input = new StubInput(in, null);
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }



    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteThenTrackerHasNoOneItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        Item item1 = new Item("2", "3", 3);
        Item item2 = new Item("4", "5", 3);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        ArrayList<String> in = new ArrayList<>();
        in.add("3");
        in.add(item.getId());
        in.add("6");
        Input input = new StubInput(in, null);
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(2));
    }


    /**
     * Test Find By Id method.
     */
    @Test
    public void whenFindIetemByIDThenCorrectItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        ArrayList<String> in = new ArrayList<>();
        in.add("4");
        in.add(item.getId());
        in.add("6");
        Input input = new StubInput(in, null);
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }



    /**
     * Test Find By Name method.
     */
    @Test
    public void whenFindIetemByNameThenCorrectItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        ArrayList<String> in = new ArrayList<>();
        in.add("5");
        in.add(item.getName());
        in.add("6");
        Input input = new StubInput(in, null);
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).getName(), is("1"));
    }


}

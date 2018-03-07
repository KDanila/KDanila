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
        ArrayList<Integer> integ = new ArrayList<>();
        integ.add(0);
        integ.add(1);
        integ.add(2);
        integ.add(3);
        Input input = new StubInput(in, integ);   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
/*

    */
/**
     * Test update method.
     *//*

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"}, new int[]{0, 1, 2, 3, 4, 5, 6});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    */
/**
     * Test delete method.
     *//*

    @Test
    public void whenDeleteThenTrackerHasNoOneItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        Item item1 = new Item("2", "3", 3);
        Item item2 = new Item("4", "5", 3);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"}, new int[]{0, 1, 2, 3, 4, 5, 6});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }

    */
/**
     * Test Find By Id method.
     *//*

    @Test
    public void whenFindIetemByIDThenCorrectItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"}, new int[]{0, 1, 2, 3, 4, 5, 6});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    */
/**
     * Test Find By Name method.
     *//*

    @Test
    public void whenFindIetemByNameThenCorrectItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("1", "2", 3);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"}, new int[]{0, 1, 2, 3, 4, 5, 6});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).getName(), is("1"));
    }
*/

}

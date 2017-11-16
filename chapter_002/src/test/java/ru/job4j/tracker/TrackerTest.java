package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test TrackerTest Class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class TrackerTest {
    /**
     * Тест add & update.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест delete and finAll().
     */
    @Test
    public void whenDeleteOneItemThenWithoutOne() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 123L);
        Item third = new Item("test3", "testDescription3", 123L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] expected = {first, second};
        tracker.delete(third);
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }
    /**
     * Тест find by name().
     */
    @Test
    public void whenSearchByNameThenFindOne() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 123L);
        Item third = new Item("test3", "testDescription3", 123L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String expected = "test2";
        assertThat(tracker.findByName("test2").getName(), is(expected));
    }
}
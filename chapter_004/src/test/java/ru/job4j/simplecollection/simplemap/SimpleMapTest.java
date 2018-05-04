package ru.job4j.simplecollection.simplemap;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * SimpleMap test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleMapTest {
    /**
     * 4. Переопределить только equals.
     */
    @Test
    public void map() {
        User one = new User("First", 2, new GregorianCalendar(1970, 2, 31));
        User two = new User("Second", 5, new GregorianCalendar(1990, 0, 31));

        Map<User, Object> map = new HashMap<User, Object>();
        map.put(one, "1");
        map.put(two, "2");
        System.out.println(map);
    }

    /**
     * 4. Переопределить только equals
     */
    @Test
    public void whenAddTwoSameUserShouldReturnTwoObjectInMap() {
        User one = new User("First", 2, new GregorianCalendar(1970, 2, 31));
        User two = new User("First", 2, new GregorianCalendar(1970, 2, 31));

        Map<User, Object> map = new HashMap<User, Object>();
        map.put(one, "1");
        map.put(two, "2");
        System.out.println(map);
    }
}
package ru.job4j.usersort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.0.1
 */
public class UserTest {
    /**
     * Test compareTo in User.
     */
    @Test
    public void whenFirstUserIsBiggerThanSecond() {
        User one = new User("Anton", 15);
        User two = new User("Boris", 30);
        int expected = -1;
        assertThat(one.compareTo(two), is(expected));
    }
}

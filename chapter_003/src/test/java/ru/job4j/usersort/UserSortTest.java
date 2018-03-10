package ru.job4j.usersort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserSortTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.0.1
 */
public class UserSortTest {
    /**
     * The first test.
     */
    @Test
    public void firstSortedTestwithTheeElement() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(
                new User("Boris", 30),
                new User("Anton", 15),
                new User("Victor", 40)
        ));
        UserSort us = new UserSort();
        us.sort(users);
        assertThat(users.get(0).getName(), is("Anton"));
        assertThat(users.get(1).getName(), is("Boris"));
    }

    /**
     * The second test.
     */
    @Test
    public void secondSortedTestwithFourElement() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(
                new User("Boris", 30),
                new User("Anton", 15),
                new User("Stanislav", 55),
                new User("Victor", 40)
        ));
        Collections.sort(users);
        assertThat(users.get(0).getName(), is("Anton"));
        assertThat(users.get(1).getName(), is("Boris"));
        assertThat(users.get(2).getName(), is("Stanislav"));
        assertThat(users.get(3).getName(), is("Victor"));
    }
}

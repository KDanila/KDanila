package ru.job4j.usersort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        UserSort us = new UserSort();
        us.sort(users);
        assertThat(users.get(0).getName(), is("Anton"));
        assertThat(users.get(1).getName(), is("Boris"));
        assertThat(users.get(2).getName(), is("Stanislav"));
        assertThat(users.get(3).getName(), is("Victor"));
    }

    /**
     * The third test.
     */
    @Test
    public void thirdSortedTestwithFourElementByNameLength() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(
                new User("Bor", 30),
                new User("Anton", 15),
                new User("Stanislav", 55),
                new User("Victor", 40)
        ));
        UserSort us = new UserSort();
        us.sortNameLength(users);
        assertThat(users.get(0).getName(), is("Bor"));
        assertThat(users.get(1).getName(), is("Anton"));
        assertThat(users.get(2).getName(), is("Victor"));
        assertThat(users.get(3).getName(), is("Stanislav"));
    }

    /**
     * The fourth test.
     */
    @Test
    public void fourthSortedTestwithFiveElementByTwoFields() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(
                new User("Boris", 30),
                new User("Boris", 15),
                new User("Stanislav", 55),
                new User("Stanislav", 40),
                new User("Anton", 40)
        ));
        UserSort us = new UserSort();
        us.sortByAllFields(users);
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getName());
            result.add(String.valueOf(user.getAge()));
        }
        expected.add("Anton");
        expected.add("40");
        expected.add("Boris");
        expected.add("15");
        expected.add("Boris");
        expected.add("30");
        expected.add("Stanislav");
        expected.add("40");
        expected.add("Stanislav");
        expected.add("55");
        assertThat(result, is(expected));

    }

    /**
     * The Fifth Test.
     */
    @Test
    public void fifthSortedTestwithFourElementByTwoFields() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));
        UserSort us = new UserSort();
        us.sortByAllFields(users);
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getName());
            result.add(String.valueOf(user.getAge()));
        }
        expected.add("Иван");
        expected.add("25");
        expected.add("Иван");
        expected.add("30");
        expected.add("Сергей");
        expected.add("20");
        expected.add("Сергей");
        expected.add("25");
        assertThat(result, is(expected));

    }


}

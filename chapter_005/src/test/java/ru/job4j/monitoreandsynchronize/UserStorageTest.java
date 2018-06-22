package ru.job4j.monitoreandsynchronize;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * UserStorageTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class UserStorageTest {
    /**
     * 1st test.
     */
    @Test
    public void whenUpdateAndUserExist() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        assertThat(one.getAmount(), is(100));
        User two = new User(1, 200);
        userStorage.update(two);
        assertThat(one.getAmount(), is(100));
    }

    /**
     * 2nd test.
     */
    @Test
    public void whenDeleteShouldDeleteCorrectly() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 200);
        userStorage.add(one);
        userStorage.add(two);
        assertThat(userStorage.delete(one), is(true));
        assertThat(userStorage.getUser(2), is(two));
    }

    /**
     * 3d test.
     */
    @Test(expected = RuntimeException.class)
    public void whenDeleteAndUserDoesNotExistShouldReturnError() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 200);
        userStorage.add(one);
        userStorage.add(two);
        userStorage.delete(one);
        userStorage.delete(one);
    }

    /**
     * 4th test.
     */
    @Test
    public void whenTransferShouldReturnCorrectData() {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 100);
        User two = new User(2, 200);
        userStorage.add(one);
        userStorage.add(two);
        userStorage.transfer(1, 2, 100);
        assertThat(one.getAmount(), is(0));
        assertThat(two.getAmount(), is(300));
    }
}
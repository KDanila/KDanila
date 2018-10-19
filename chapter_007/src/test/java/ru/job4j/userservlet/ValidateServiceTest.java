package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * ValidateServiceTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class ValidateServiceTest {
    /**
     * user1.
     */
    private User user1 = new User.UserBuilder("Artem").build();
    /**
     * user2.
     */
    private User user2 = new User.UserBuilder("Egor").build();
    /**
     * user3.
     */
    private User user3 = new User.UserBuilder("Semen").build();

    /**
     * whenAddThreeUsersThenCorrect.
     */
    @Test
    public void whenAddThreeUsersThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(user1, is(validateService.findById(user1.getId())));
        assertThat(user2, is(validateService.findById(user2.getId())));
        assertThat(user3, is(validateService.findById(user3.getId())));
    }

    /**
     * whenUpdateUserThenCorrect.
     */
    @Test
    public void whenUpdateUserThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        user1 = user2;
        validateService.update(user1);
        assertThat(user1, is(validateService.findById(user2.getId())));
    }

    /**
     * whenDeleteUserThenCorrect.
     */
    @Test
    public void whenDeleteUserThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        assertThat(validateService.delete(user1), is(true));
    }

    /**
     * whenUseFindAllThenReturnAllUsers.
     */
    @Test
    public void whenUseFindAllThenReturnAllUsers() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(validateService.findAll().get(user1.getId()).getName(), is("Artem"));
        assertThat(validateService.findAll().get(user2.getId()).getName(), is("Egor"));
        assertThat(validateService.findAll().get(user3.getId()).getName(), is("Semen"));
    }

}
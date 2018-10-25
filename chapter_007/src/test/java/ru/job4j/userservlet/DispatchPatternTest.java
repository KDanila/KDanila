package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * DispatchPatternTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class DispatchPatternTest {
    /**
     * adding user by dispatch pattern.
     */
    @Test
    public void whenAddUserThenReturnTrue() {
        ValidateService vs = ValidateService.getInstance();
        User u = new User.UserBuilder("Name").build();

        assertThat(new DispatchPattern().init().action(
                () -> Action.StoreAction.ADD,
                vs,
                u), is(true));
    }

}
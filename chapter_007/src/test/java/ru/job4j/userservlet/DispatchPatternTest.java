package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DispatchPatternTest {

    @Test
    public void whenAddUserThenReturnTrue() {
        Store s = MemoryStore.getInstance();
        User u = new User.UserBuilder("Name").build();

        assertThat(new DispatchPattern().init().action(
                () -> Action.StoreAction.ADD,
                s,
                u)
                , is(true));
    }

}
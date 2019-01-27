package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MemoryStoreTest {

    @Test
    public void whenUpdateThanCorrectly() {
        MemoryStore ms = MemoryStore.MEMORY_STORE;
        User user1 = new User.UserBuilder("Artem").email("1").login("1").email("1111").build();
        User user2 = new User.UserBuilder("Egor").email("2").login("2").email("2222").build();
        ms.add(user1);
        ms.add(user2);
        ms.update(String.valueOf(user1.getId()), user2);
        System.out.println(user1.getName());
        assertThat(user1.getName().equals("Egor"), is(true));
    }

    @Test
    public void  whenIsAccesAllowedTrueWhenReturnTrue(){
        MemoryStore ms = MemoryStore.MEMORY_STORE;
        System.out.println(ms.findAll());
    }

    @Test
    public void  whenAddUserThenReturnTrue(){
        MemoryStore ms = MemoryStore.MEMORY_STORE;
        ValidateService validateService = ValidateService.getInstance();
        System.out.println(validateService.findAll().toString());
        System.out.println(ms.findById(0));
        System.out.println(ms.findAll());
    }
}
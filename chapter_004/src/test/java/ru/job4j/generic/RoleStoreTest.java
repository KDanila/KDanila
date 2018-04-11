package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddUserShouldReturnCorrectReult() {
     User user = new User("first");
     RoleStore us = new RoleStore();
     us.add(user);
     Role role = new Role("Wrong");
     us.add(role);

    }
}
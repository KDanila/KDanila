package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenSetInRoleStoreUserShouldError() {
     User user = new User("111");
     Role role = new Role("222");
     RoleStore rs = new RoleStore();
     rs.add(user);
    }
}
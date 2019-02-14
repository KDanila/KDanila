package ru.job4j.userservlet;

import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DBStoreTest {
    DBStore dbStore = DBStore.getInstance();
    User user1 = new User.UserBuilder("Artem").email("1").login("1").password("1111").build();
    User user2 = new User.UserBuilder("Egor").email("2").login("2").password("2222").build();


    @Test
    public void whenGetInstanceOfDbStoreShouldReturnNoNullSatement() {
        assertNotNull(dbStore.getConnection());
    }

    @Test
    public void whenCreateTableInDbShouldCreateProperly() {
        assertThat(dbStore.checkTableInDB(), is(true));
    }

    @Test
    public void whenAddValuesAndFinByidInTableShouldReturnCirrectUserName() {
        dbStore.add(user1);
        int id = dbStore.findByLogin(user1.getLogin()).getId();
        assertThat(dbStore.findById(id).getName(), is(user1.getName()));
    }

    @Test
    public void whenDeleteUserShouldDeleteUser() {
        dbStore.add(user1);
        assertThat(dbStore.delete(user1), is(true));
    }

    @Test
    public void whenUseFindAllShouldReturnCorrectValue() {
        dbStore.add(user1);
        dbStore.add(user2);
        int id1 = dbStore.findByLogin(user1.getLogin()).getId();
        int id2 = dbStore.findByLogin(user2.getLogin()).getId();
        assertThat(dbStore.findAll().get(id1).getName(), is(user1.getName()));
        assertThat(dbStore.findAll().get(id2).getName(), is(user2.getName()));
    }

    @Test
    public void whenUseUpdateShouldCorrectUpdated() {
        dbStore.add(user1);
        dbStore.add(user2);
        dbStore.update(String.valueOf(user1.getId()), user2);
    }

    @Test
    public void whenAccessAllowedShouldReturnCorrectValue() {
        dbStore.add(user1);
        dbStore.add(user2);
        boolean stateTrue = dbStore.isAccessAllowed(user1.getLogin(), user1.getPassword());
        boolean stateFalse = dbStore.isAccessAllowed(user1.getLogin(), user2.getPassword());
        assertThat(stateTrue, is(true));
        assertThat(stateFalse, is(false));
    }

    @Test
    public void whenUseFindByLoginAndLoginExistShouldReturnCorrectValue() {
        dbStore.add(user1);
        dbStore.add(user2);
        User toCheck = dbStore.findByLogin(user1.getLogin());
        assertThat(toCheck.getName(), is(user1.getName()));
    }

}
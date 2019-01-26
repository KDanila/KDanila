package ru.job4j.userservlet;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DBStoreTest {

    @Test
    public void whenGetInstanceOfDbStoreShouldReturnNoNullSatement(){
        DBStore dbStore = DBStore.getInstance();
        assertNotNull(dbStore.getConnection());
    }
    @Test
    public void whenStringPathCorrectShould(){
        String path = "configDbStore.properties";
        File file = new File(path);
       // System.out.println(file.exists());
    }

}
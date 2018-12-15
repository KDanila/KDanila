package ru.job4j.userservlet;

import java.util.Map;

import java.sql.Connection;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;
//TODO sql DB store
public class DBStore implements Store<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DBStore INSTANCE = new DBStore();

    public DBStore() {
        SOURCE.setUrl("...");
        SOURCE.setUsername("...");
        SOURCE.setPassword("...");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(User user) {
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.prepareStatement("...")
        ) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public Map<Integer, User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}


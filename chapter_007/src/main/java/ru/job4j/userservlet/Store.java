package ru.job4j.userservlet;

import java.util.Map;

public interface Store {
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    Map<Integer, User> findAll();
    User findById(int id);
}

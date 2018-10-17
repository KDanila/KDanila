package ru.job4j.userservlet;

import java.util.List;

public interface Store {
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    List<User> findAll();
    User findById(int id);
}

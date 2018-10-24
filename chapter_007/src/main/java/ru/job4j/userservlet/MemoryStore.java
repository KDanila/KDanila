package ru.job4j.userservlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {

    private static final Map<Integer, User> USERS = new ConcurrentHashMap<>();

    public static final MemoryStore MEMORY_STORE = new MemoryStore();

    private MemoryStore() {
    }

    public static Store getInstance() {
        return MEMORY_STORE;
    }

    @Override
    public boolean add(User user) {
        this.USERS.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean update(User user) {
        this.USERS.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        this.USERS.remove(user);
        return true;
    }

    @Override
    public Map<Integer, User> findAll() {
        return this.USERS;
    }

    @Override
    public User findById(int id) {
        return this.USERS.get(id);
    }
}

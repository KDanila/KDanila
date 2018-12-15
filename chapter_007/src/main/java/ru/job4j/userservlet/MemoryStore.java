package ru.job4j.userservlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MemoryStore class.
 * <p>
 * Use singleton pattern.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class MemoryStore implements Store<User> {
    /**
     * users hashmap.
     */
    private static final Map<Integer, User> USERS = new ConcurrentHashMap<>();
    /**
     * EMORY STORE INSTANCE.
     */
    public static final MemoryStore MEMORY_STORE = new MemoryStore();

    /**
     * private constructor.
     */
    private MemoryStore() {
    }

    /**
     * getInstance method.
     *
     * @return Store.
     */
    public static Store<User> getInstance() {
        return MEMORY_STORE;
    }

    /**
     * add method.
     *
     * @param user - user
     * @return boolean.
     */
    @Override
    public boolean add(User user) {
        this.USERS.put(user.getId(), user);
        return true;
    }

    /**
     * update method.
     *
     * @param user - user
     * @return boolean.
     */
    @Override
    public boolean update(User user) {
        User u = new User.UserBuilder(user.getName()).login(user.getLogin()).email(user.getEmail()).build();
        this.USERS.replace(user.getId(), u);
        return true;
    }

    /**
     * delete method.
     *
     * @param user - user
     * @return boolean.
     */
    @Override
    public boolean delete(User user) {
        this.USERS.remove(user.getId(), user);
        return true;
    }

    /**
     * findAll method.
     *
     * @return Map.
     */
    @Override
    public Map<Integer, User> findAll() {
        return this.USERS;
    }

    /**
     * findById method.
     *
     * @param id - int.
     * @return - User.
     */
    @Override
    public User findById(int id) {
        return this.USERS.get(id);
    }
}

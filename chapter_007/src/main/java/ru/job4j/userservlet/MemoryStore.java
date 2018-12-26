package ru.job4j.userservlet;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

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
        boolean isExist = isUserExist(user);
        boolean isUnique = isUserUnique(user);
        if (!isExist && isUnique) {
            this.USERS.putIfAbsent(user.getId(), user);
            return true;
        }
        return false;
    }

    public boolean isUserUnique(User user) {
        String login = user.getLogin();
        String email = user.getEmail();
        if (login == null || email == null) {
            return false;
        }
        return !this.USERS.values().stream().anyMatch(u-> u.equals(user));
    }
    /**
     * isUserExist method.
     *
     * @param user - user.
     * @return boolean.
     */
    private boolean isUserExist(User user) {
        return USERS.containsKey(user.getId());
    }

    /**
     * update method.
     *
     * @param id
     * @param user - user
     * @return boolean.
     */
    @Override
    public boolean update(String id, User user) {
        User toUpdate = this.findById(Integer.valueOf(id));
        Objects.requireNonNull(toUpdate);
        toUpdate.setName(user.getName());
        toUpdate.setLogin(user.getLogin());
        toUpdate.setEmail(user.getEmail());
        boolean isExist = isUserExist(user);
        if (!isExist&&isUserUnique(user)) {
            this.USERS.put(Integer.valueOf(id), toUpdate);
            return true;
        }
        return false;
    }

    /**
     * delete method.
     *
     * @param user - user
     * @return boolean.
     */
    @Override
    public boolean delete(User user) {
        boolean isExist = isUserExist(user);
        if (isExist) {
            this.USERS.remove(user.getId(), user);
            return true;
        }
        return false;
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

    @Override
    public boolean isAccessAllowed(String login, String password) {
        return this.USERS.values().stream()
                .peek(System.out::println)
                .anyMatch(user -> user.getLogin().equals(login) &&
                        user.getPassword().equals(password));
    }

    @Override
    public User findByLogin(String login) {
        return this.USERS.values().stream().filter(u -> u.getLogin().equals(login)).findFirst().get();
    }
}

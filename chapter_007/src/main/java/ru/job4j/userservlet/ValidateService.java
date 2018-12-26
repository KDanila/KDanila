package ru.job4j.userservlet;

import java.util.Map;


/**
 * MemoryStore class.
 * <p>
 * Use singleton pattern.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class ValidateService {
    /**
     * VALIDATE_SERVICE.
     */
    private static final ValidateService VALIDATE_SERVICE = new ValidateService();
    /**
     * Store.
     */
    private final Store<User> store = MemoryStore.getInstance();

    /**
     * private constructor.
     */
    private ValidateService() {
        store.add(new User.UserBuilder("admin").login("admin").password("admin").build());
    }

    /**
     * getInstance() method.
     *
     * @return ValidateService
     */
    public static ValidateService getInstance() {
        return VALIDATE_SERVICE;
    }

    /**
     * add method.
     *
     * @param user - user.
     * @return boolean.
     */
    boolean add(User user) {
        boolean isExist = isUserExist(user);
        boolean isUnique = isUserUnique(user);
        if (!isExist && !isUnique) {
            this.store.add(user);
        }
        return isExist;
    }

    public boolean isUserUnique(User user) {
        String login = user.getLogin();
        String email = user.getEmail();
        if (login == null || email == null) {
            return false;
        }
        return this.findAll().values().stream().anyMatch(u-> u.equals(user));
    }

    /**
     * update method.
     *
     * @param id
     * @param user - user.
     * @return boolean.
     */
    boolean update(String id, User user) {
        boolean isExist = isUserExist(user);
        if (!isExist) {
            this.store.update(id,user);
        }
        return isExist;
    }

    /**
     * delete method.
     *
     * @param user - user.
     * @return boolean.
     */
    boolean delete(User user) {
        boolean isExist = isUserExist(user);
        if (isExist) {
            this.store.delete(user);
        }
        return isExist;
    }

    /**
     * @param login
     * @param password
     * @return
     */
    public boolean isAccessAllowed(String login, String password) {
        return this.store.isAccessAllowed(login, password);
    }

    /**
     * isUserExist method.
     *
     * @param user - user.
     * @return boolean.
     */
    private boolean isUserExist(User user) {
        return this.store.findById(user.getId()) != null;
    }

    /**
     * findAll method.
     *
     * @return Map.
     */
    public Map<Integer, User> findAll() {
        return this.store.findAll();
    }

    /**
     * findById method.
     *
     * @param id - int.
     * @return - User.
     */
    User findById(int id) {
        return this.store.findById(id);
    }
    /**
     * findByLogin method.
     *
     * @param login - String.
     * @return - User.
     */
    User findByLogin(String login) {
        return this.store.findByLogin(login);
    }
}

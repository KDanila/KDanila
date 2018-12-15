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
    private final Store<U> store = MemoryStore.getInstance();

    /**
     * private constructor.
     */
    private ValidateService() {
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
        if (!isExist) {
            this.store.add(user);
        }
        return isExist;
    }

    /**
     * update method.
     *
     * @param user - user.
     * @return boolean.
     */
    boolean update(User user) {
        boolean isExist = isUserExist(user);
        if (!isExist) {
            this.store.update(user);
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
}

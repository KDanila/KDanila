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
    //private final Store<User> store = MemoryStore.getInstance();
    private final Store<User> store = DBStore.getInstance();

    /**
     * private constructor.
     */
    private ValidateService() {
        store.add(new User.UserBuilder("admin").login("admin").email("admin").password("admin").build());
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
        boolean isAdded = this.store.add(user);
        if (!isAdded) {
            decreaseId();
            isAdded = false;
        }
        return isAdded;
    }


    /**
     * update method.
     *
     * @param id
     * @param user - user.
     * @return boolean.
     */
    boolean update(String id, User user) {
        boolean isUpdate = this.store.update(id, user);
        if (!isUpdate) {
            decreaseId();
            isUpdate = false;
        }
        return isUpdate;
    }

    /**
     * delete method.
     *
     * @param user - user.
     * @return boolean.
     */
    boolean delete(User user) {
        boolean isDelete = this.store.delete(user);
        if (isDelete) {
            decreaseId();
            isDelete = false;
        }
        return isDelete;
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

    void decreaseId() {
        System.out.println(User.getCounter());
        User.setCounter(User.getCounter() - 1);
        System.out.println(User.getCounter());
    }
}

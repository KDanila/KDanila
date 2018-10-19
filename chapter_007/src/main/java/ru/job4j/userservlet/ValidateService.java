package ru.job4j.userservlet;

import java.util.Map;

//todo
/*
Далее создайте класс ValidateService - это слой Logic. В нем нужно добавить методы
add, update, delete, findAll, findById

Каждый метод должен производить валидацию данных. Например, при обновлении полей нужно проверить.
что такой пользователь существует.


Класс ValidateService сделать синглетоном. Использовать Eager initialisation.
 */
public class ValidateService {
    private static final ValidateService VALIDATE_SERVICE = new ValidateService();
    private final Store store = MemoryStore.getInstance();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return VALIDATE_SERVICE;
    }

    boolean add(User user) {
        boolean isExist = isUserExist(user);
        if (!isExist) {
            this.store.add(user);
        }
        return isExist;
    }

    boolean update(User user) {
        boolean isExist = isUserExist(user);
        if (!isExist) {
            this.store.update(user);
        }
        return isExist;
    }

    boolean delete(User user) {
        boolean isExist = isUserExist(user);
        if (isExist) {
            this.store.delete(user);
        }
        return isExist;
    }

    private boolean isUserExist(User user) {
        return this.store.findById(user.getId()) != null;
    }

    Map<Integer, User> findAll() {
        return this.store.findAll();
    }

    User findById(int id) {
        return this.store.findById(id);
    }
}

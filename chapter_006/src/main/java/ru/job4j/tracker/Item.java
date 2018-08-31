package ru.job4j.tracker;

import java.sql.Timestamp;
import java.util.Random;

/**
 * Item класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Item {


    /**
     * Переменная для генерации уникального id.
     */
    public static final Random RN = new Random(1000);
    /**
     * name - имя заявки.
     */
    private String name;
    /**
     * description - описание заявки.
     */
    private String description;

    /**
     * create - время создания в милисекундах.
     */
    private Timestamp createTime;
    /**
     * id - идентификационный номер заявки.
     */
    private int id;

    /**
     * Пустой конструктор.
     */
    public Item() {
        setId(generateId());
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Конструктор.
     *
     * @param name        - имя.
     * @param description - описание.
     */
    public Item(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    /**
     * Overload constructor. Создан для считывания с базы.
     *
     * @param id - id.
     * @param name - name.
     * @param description -description.
     * @param timestamp - timestamp.
     */
    public Item(int id, String name, String description, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createTime = timestamp;
    }

    /**
     * getter.
     *
     * @return id - ид.
     */
    public int getId() {
        return this.id;
    }

    /**
     * getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param id -ид.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name -имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String - описание.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description -описание.
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    int generateId() {
        return Math.abs((int)(System.currentTimeMillis() + RN.nextInt()));
    }


    /**
     * GetCreateTime method.
     *
     * @return
     */
    public Timestamp getCreateTime() {
        return createTime;
    }
}

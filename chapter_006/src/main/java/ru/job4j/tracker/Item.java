package ru.job4j.tracker;

/**
 * Item класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Item {
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
    private long create;
    /**
     * id - идентификационный номер заявки.
     */
    private String id;

    /**
     * Пустой конструктор.
     */
    public Item() {
    }

    /**
     * Конструктор.
     *
     * @param name        - имя.
     * @param description - описание.
     * @param create      - ид.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * getter.
     *
     * @return id - ид.
     */
    public String getId() {
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
    public void setId(String id) {
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
}

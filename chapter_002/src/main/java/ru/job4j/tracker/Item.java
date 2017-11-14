package main.java.ru.job4j.tracker;
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
     * create - ???.
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
     * @param name
     * @param description
     * @param create
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * getter.
     *
     * @return id.
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
     * setter.
     *
     * @param id.
     */
    public void setId(String id) {
        this.id = id;
    }
}

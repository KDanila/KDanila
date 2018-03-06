package ru.job4j.userconvert;

/**
 * User class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class User {
    /**
     * id - identificator.
     */
    private int id;
    /**
     * name - name.
     */
    private String name;
    /**
     * city - city.
     */
    private String city;

    /**
     * Constructor.
     *
     * @param id   - id.
     * @param name - name.
     * @param city - city.
     */
    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter.
     *
     * @return - int id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     *
     * @param id - int.
     */
    public void setId(int id) {
        this.id = id;
    }

}

package ru.job4j.generic;

/**
 * Base class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public abstract class Base {
    /**
     * id.
     */
    private final String id;

    /**
     * Constructor.
     *
     * @param id - id.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Getter.
     *
     * @return string.
     */
    public String getId() {
        return id;
    }
}
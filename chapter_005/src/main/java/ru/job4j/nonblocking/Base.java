package ru.job4j.nonblocking;

import java.util.Objects;

/**
 * Base class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Base {
    /**
     * Id number.
     */
    private int id;
    /**
     * Version number.
     */
    private int version;
    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param id   - id.
     * @param name - name.
     */
    public Base(int id, String name) {
        this.id = id;
        this.name = name;
        this.version = 0;
    }

    /**
     * Modify version method.
     * Just increase version by one.
     */
    public void modifyVersion() {
        this.version++;
    }

    /**
     * Version getter.
     *
     * @return version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Name setter.
     *
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Id getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Equals method.
     *
     * @param o - income object.
     * @return boolean statement.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                && Objects.equals(name, base.name);
    }

    /**
     * Hash code method.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

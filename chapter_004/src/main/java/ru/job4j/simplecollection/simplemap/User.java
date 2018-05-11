package ru.job4j.simplecollection.simplemap;

import java.util.Calendar;

/**
 * SimpleHashSet class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Number of children.
     */
    private int children;
    /**
     * Birthday.
     */
    private Calendar birthday;

    /**
     * Constructor.
     *
     * @param name     - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Getter name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name.
     *
     * @param name -name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Setter.
     *
     * @param children - int.
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * Getter.
     *
     * @return calendar date.
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * Setter.
     *
     * @param birthday - date.
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getChildren() != user.getChildren()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getBirthday() != null ? getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getChildren();
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }
}

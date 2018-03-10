package ru.job4j.usersort;

/**
 * User class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.0.1
 */
public class User implements Comparable<User> {
    /**
     * String name - name.
     */
    private String name;
    /**
     * int age - age.
     */
    private int age;

    /**
     * Constructor.
     *
     * @param name - name.
     * @param age  - age.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Name getter.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Age getter.
     *
     * @return int age.
     */
    public int getAge() {
        return age;
    }

    /**
     * @param o - user to compare.
     * @return int -1, 0 ,1. For more details see String compareTo.
     */
    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.getName());
    }
}

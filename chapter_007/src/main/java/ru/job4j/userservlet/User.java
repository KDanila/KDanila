package ru.job4j.userservlet;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User class.
 * <p>
 * Pattern builder.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class User {
    /**
     * id.
     */
    private AtomicInteger id;


    private String password;


    private static AtomicInteger counter = new AtomicInteger(0);
    /**
     * name.
     */
    private String name;
    /**
     * login.
     */
    private String login;

    /**
     * email.
     */
    private String email;
    /**
     * createDate.
     */
    private final ZonedDateTime createDate;

    /**
     * User constructor.
     *
     * @param userBuilder - userBuilder.
     */
    public User(UserBuilder userBuilder) {
        this.id = new AtomicInteger(counter.getAndIncrement());
        this.name = userBuilder.name;
        this.login = userBuilder.login;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.createDate = userBuilder.createDate;
    }

    /**
     * toSting.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + ", createDate=" + createDate
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, email);
    }


    /**
     * Class userBuilder.
     */
    static class UserBuilder {
        /**
         * name.
         */
        private final String name;
        /**
         * createDate.
         */
        private ZonedDateTime createDate;
        /**
         * login.
         */
        private String login;
        /**
         * email.
         */
        private String email;

        private String password;

        /**
         * constructor.
         *
         * @param name - name.
         */
        UserBuilder(String name) {
            this.name = name;
        }

        /**
         * constructor.
         *
         * @param password - name.
         */
        UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * login method.
         *
         * @param login - string.
         * @return UserBuilder.
         */
        UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        /**
         * email method.
         *
         * @param email - string.
         * @return UserBuilder.
         */
        UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * createDate method.
         *
         * @param date - ZonedDateTime.
         * @return UserBuilder.
         */
        UserBuilder createDate(ZonedDateTime date) {
            this.createDate = date;
            return this;
        }

        /**
         * build method.
         *
         * @return User.
         */
        User build() {
            return new User(this);
        }

    }

    /**
     * Getter.
     *
     * @return int.
     */
    public int getId() {
        return id.get();
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter.
     *
     * @return ZonedDateTime.
     */
    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static int getCounter() {
        return counter.get();
    }

    public static void setCounter(int value) {
        User.counter.set(value);
    }

}
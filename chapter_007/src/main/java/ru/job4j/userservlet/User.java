package ru.job4j.userservlet;

import java.time.ZonedDateTime;
import java.util.Random;

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
    private final int id;
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
        this.id = generateId();
        this.name = userBuilder.name;
        this.login = userBuilder.login;
        this.email = userBuilder.email;
        this.createDate = userBuilder.createDate;
    }

    /**
     * naive id generator.
     *
     * @return int.
     */
    private int generateId() {
        return new Random().nextInt(10000);
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
                + ", createDate=" + createDate
                + '}';
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

        /**
         * constructor.
         *
         * @param name - name.
         */
        UserBuilder(String name) {
            this.name = name;
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
        return id;
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
        this.name =  name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

/*




 */
package ru.job4j.userservlet;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class User {
    private final int id;
    private final String name;
    private final String login;
    private final String email;


    private final ZonedDateTime createDate;


    public User(UserBuilder userBuilder) {
        this.id = generateId();
        this.name = userBuilder.name;
        this.login = userBuilder.login;
        this.email = userBuilder.email;
        this.createDate = userBuilder.createDate;
    }

    /**
     * naive id generator
     *
     * @return
     */
    private int generateId() {
        return new Random().nextInt(10000);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    static class UserBuilder {
        private final String name;
        public ZonedDateTime createDate;
        private String login;
        private String email;

        public UserBuilder(String name) {
            this.name = name;
        }


        UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        UserBuilder createDate(ZonedDateTime date) {
            this.createDate = date;
            return this;
        }

        User build() {
            return new User(this);
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }


    public ZonedDateTime getCreateDate() {
        return createDate;
    }

}

package ru.job4j.banktransfer;

/**
 * User class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class User {
    /**
     * name - String.
     */
    private String name;
    /**
     * passport - String.
     */
    private String passport;

    /**
     * Constructor.
     *
     * @param name     - name.
     * @param passport - passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Getter.
     *
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name - String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return - passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Setter.
     *
     * @param passport - passport.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Equals.
     *
     * @param o - income User object.
     * @return - boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        if (!getName().equals(user.getName())) {
            return false;
        }
        return getPassport().equals(user.getPassport());
    }

    /**
     * Hash code.
     *
     * @return int hash code.
     */
    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPassport().hashCode();
        return result;
    }

}

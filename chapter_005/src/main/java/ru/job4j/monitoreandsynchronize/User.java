package ru.job4j.monitoreandsynchronize;

/**
 * User class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class User {
    /**
     * Identification number of User.
     */
    private int id;

    /**
     * Ammount of money on account.
     */
    private int amount;

    /**
     * Constructor.
     *
     * @param id     - id.
     * @param amount - amount money.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Getter id.
     *
     * @return - id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter amount.
     *
     * @return - amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter amount.
     *
     * @param amount - amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}

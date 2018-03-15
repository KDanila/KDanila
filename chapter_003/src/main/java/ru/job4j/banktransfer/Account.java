package ru.job4j.banktransfer;

/**
 * Account class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Account {
    /**
     * value - double.
     */
    private double value;
    /**
     * requisites - String.
     */
    private String requisites;

    /**
     * Constructor.
     *
     * @param value      - value.
     * @param requisites - requisites.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Getter.
     *
     * @return value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter.
     *
     * @param value - value.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter.
     *
     * @return requisites.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Setter.
     *
     * @param requisites - requisites.
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

}

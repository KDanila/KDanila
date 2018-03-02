package ru.job4j.search;

/**
 * Person class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Person {
    /**
     * Name,surname,phone,address.
     */
    private String name, surname, phone, address;

    /**
     * @param name    - name.
     * @param surname -surname.
     * @param phone   -phone.
     * @param address - address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * getter.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * getter.
     *
     * @return String surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * getter.
     *
     * @return String phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * getter.
     *
     * @return String address.
     */
    public String getAddress() {
        return address;
    }
}
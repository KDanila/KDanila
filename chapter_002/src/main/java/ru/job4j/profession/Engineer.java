package ru.job4j.profession;

/**
 * Engineer class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    /**
     * @param time      - time to create product.
     * @param education - level of engenir's education.
     * @param money     - amount of money ti create product.
     * @return product.
     */
    public Product createProduct(Time time, Education education, int money) {
        return new Product();
    }
}

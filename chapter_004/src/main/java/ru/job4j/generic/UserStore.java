package ru.job4j.generic;

/**
 * UserStore class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Constructor.
     *
     * @param size - size.
     */
    protected UserStore(int size) {
        super(size);
    }
}

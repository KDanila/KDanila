package ru.job4j.nonblocking;

/**
 * OptimisticException class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg - msg to show.
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}

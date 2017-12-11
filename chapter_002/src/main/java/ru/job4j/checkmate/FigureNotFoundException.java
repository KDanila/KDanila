package ru.job4j.checkmate;
/**
 * FigureNotFoundException class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * FigureNotFoundException.
     */
    FigureNotFoundException() {
        super("Figure not found");
    }
}


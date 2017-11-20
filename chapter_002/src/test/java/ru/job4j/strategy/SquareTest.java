package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test SquareTest Class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    /**
     * Тест square.pic.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.pic(),
                is(
                        new StringBuilder().
                                append(" ____\n|    |\n|____|\n ")
                                .toString()
                )
        );
    }
}



package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test TriangleTest Class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */


public class TriangleTest {
    /**
     * Тест triangle.pic.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.pic(),
                is(
                        new StringBuilder().
                                append("|\\\n| \\\n|__\\\n")
                                .toString()
                )
        );
    }
}

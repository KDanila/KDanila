package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StringContainTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StringContainTest {
    /**
     * Привет содержит иве.
     */
    @Test
    public void whenPrivetAndIveThenTrue() {
        StringContain stringContain = new StringContain();
        boolean expected = true;
        boolean result = stringContain.contains("Привет", "иве");
        assertThat(result, is(expected));
    }

    /**
     * Приветприветпока содержит ока.
     */
    @Test
    public void whenPrivetPrivetPokaAndOkaThenTrue() {
        StringContain stringContain = new StringContain();
        boolean expected = true;
        boolean result = stringContain.contains("Приветприветпока", "ока");
        assertThat(result, is(expected));
    }

    /**
     * Привет содержит ока.
     */
    @Test
    public void whenPrivetAndOkaThenFalse() {
        StringContain stringContain = new StringContain();
        boolean expected = false;
        boolean result = stringContain.contains("Привет", "ока");
        assertThat(result, is(expected));
    }
}

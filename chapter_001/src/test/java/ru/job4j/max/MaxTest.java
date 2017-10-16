package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Max Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     * Test maximum of 1 and 2.
     *
     * @param first  is first number.
     * @param second is second number.
     */
    @Test
    public void whenFirstLessSecond(int first, int second) {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test maximum of 5 and 5.
     *
     * @param first  is first number.
     * @param second is second number.
     */
    @Test
    public void whenFiveandFive(int first, int second) {
        Max maximum = new Max();
        int result = maximum.max(5, 5);
        assertThat(result, is(5));
    }

    /**
     * Test maximum of -100 and -50.
     *
     * @param first  is first number.
     * @param second is second number.
     */
    @Test
    public void whenFirstIsMinusLessSecondMinus(int first, int second) {
        Max maximum = new Max();
        int result = maximum.max(-100, -50);
        assertThat(result, is(-50));
    }
}

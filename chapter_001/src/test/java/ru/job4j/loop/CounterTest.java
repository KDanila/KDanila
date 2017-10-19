package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Loop Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    /**
     * Test.
     */
    @Test
    public void whenZeroToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(0, 10);
        assertThat(result, is(30));
    }
    /**
     * Test Zero.
     */
    @Test
    public void whenStartAndFinishTheSameThenZero() {
        Counter counter = new Counter();
        int result = counter.add(0, 0);
        assertThat(result, is(0));
    }
}

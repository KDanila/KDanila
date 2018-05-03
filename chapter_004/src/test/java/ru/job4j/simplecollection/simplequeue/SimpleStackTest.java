package ru.job4j.simplecollection.simplequeue;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Simple Stack Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleStackTest {
    /**
     * Test push and poll.
     */
    @Test
    public void whenAddAndPushThenCorrectReturnData() {
        SimpleStack<Integer> ss = new SimpleStack<>();
        ss.push(1);
        ss.push(2);
        ss.push(3);
        assertThat(ss.poll(), is(3));
        assertThat(ss.poll(), is(2));
        assertThat(ss.poll(), is(1));
    }

}
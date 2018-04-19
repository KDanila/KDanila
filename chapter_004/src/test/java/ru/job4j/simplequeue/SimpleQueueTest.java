package ru.job4j.simplequeue;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * SimpleQueue Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleQueueTest {
    /**
     * Push and Poll test.
     */
    @Test
    public void whenPushShouldBePush() {
        SimpleQueue<String> sq = new SimpleQueue<>();
        sq.push("0");
        sq.push("1");
        sq.push("2");
        assertThat(sq.poll(), is("0"));
        assertThat(sq.poll(), is("1"));
        assertThat(sq.poll(), is("2"));
    }

}
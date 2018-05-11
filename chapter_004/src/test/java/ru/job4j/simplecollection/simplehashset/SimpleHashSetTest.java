package ru.job4j.simplecollection.simplehashset;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * SimpleHashSet class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleHashSetTest {
    /**
     * testing add and contains method.
     */
    @Test
    public void whenHashSetAddReturnCorrectResults() {
        SimpleHashSet<String> shs = new SimpleHashSet<>();
        shs.add("0");
        shs.add("1");
        shs.add("2");
        shs.add("4");

        assertThat(shs.contains("0"), is(true));
        assertThat(shs.contains("1"), is(true));
        assertThat(shs.contains("2"), is(true));
        assertThat(shs.contains("3"), is(false));
        assertThat(shs.contains("4"), is(true));

    }

    /**
     * testing delete method.
     */
    @Test
    public void whenHashSetRemoveReturnCorrectResults() {
        SimpleHashSet<String> shs = new SimpleHashSet<>();
        shs.add("0");
        shs.add("1");
        shs.add("2");
        shs.add("4");
        shs.remove("0");
        shs.remove("22");

        assertThat(shs.contains("0"), is(false));
        assertThat(shs.contains("1"), is(true));
        assertThat(shs.contains("2"), is(true));
        assertThat(shs.contains("3"), is(false));
        assertThat(shs.contains("4"), is(true));

    }

    /**
     * testing increase method.
     */
    @Test
    public void whenIncreaseSetSchouldIncreaseCorrectly() {
        SimpleHashSet<String> shs = new SimpleHashSet<>(4);
        shs.add("0");
        shs.add("1");
        shs.add("1");

        assertThat(shs.getHashSetLength(), is(8));

    }

    /**
     * testing increase method.
     */
    @Test
    public void whenSecondIncreaseSetSchouldIncreaseCorrectly() {
        SimpleHashSet<String> shs = new SimpleHashSet<>(4);
        shs.add("0");
        shs.add("1");
        shs.add("2");
        shs.add("3");
        shs.add("4");
        shs.add("5");

        assertThat(shs.getHashSetLength(), is(16));

        shs.remove("0");
        shs.remove("1");
        shs.remove("2");
        shs.remove("3");

        assertThat(shs.getHashSetLength(), is(16));
    }

}
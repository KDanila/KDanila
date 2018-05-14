package ru.job4j.simplecollection.simplemap;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * SimpleMap test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleMapTest {
    /**
     * Add & get test.
     */
    @Test
    public void whenAddShouldCorrectReturnByGet() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>(4);
        simpleMap.insert(1, "first");
        simpleMap.insert(2, "second");
        simpleMap.insert(3, "third");
        assertThat(simpleMap.get(1), is("first"));
        assertThat(simpleMap.get(2), is("second"));
        assertThat(simpleMap.get(3), is("third"));
        assertThat(simpleMap.getSize(), is(8));
    }

    /**
     * Delete testing.
     */
    @Test
    public void whenDeleteShouldCorrectReturnByGet() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.insert(1, "first");
        simpleMap.insert(2, "second");
        simpleMap.insert(3, "third");
        simpleMap.delete(2);
        String expected = null;
        assertThat(simpleMap.get(1), is("first"));
        assertThat(simpleMap.get(2), is(expected));
        assertThat(simpleMap.get(3), is("third"));
    }
}
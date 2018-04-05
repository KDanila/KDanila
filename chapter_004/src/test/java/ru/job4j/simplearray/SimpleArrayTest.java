package ru.job4j.simplearray;


import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * SimpleArrayTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleArrayTest {
    /**
     * Create container type test.
     */
    @Test
    public void whenCreateContainerShouldReturnSameType() {
        SimpleArray<String> simple = new SimpleArray<>(10);
        simple.add("Test");
        String result = simple.get(0);
        assertThat(result, is("Test"));
    }

    /**
     * Integer type test.
     */
    @Test
    public void whenCreateIntegerContainerShouldReturnInteger() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        int result = simple.get(0);
        assertThat(result, is(1));
    }

    /**
     * Test set method.
     */
    @Test
    public void whenSetStatementShouldAddIt() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("Test");
        simpleArray.set(0, "!Test");
        String result = simpleArray.get(0);
        assertThat(result, is("!Test"));
    }

    /**
     * Test delete method.
     *
     * @throws Exception - exception.
     */
    @Test
    public void whenDeleteElementShouldDelete() throws Exception {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("Test");
        simpleArray.add("Test1");
        simpleArray.add("Test2");
        simpleArray.delete(0);
        String result = simpleArray.get(0);
        assertThat(result, is("Test1"));
    }

    /**
     * Test iterator method.
     */
    @Test
    public void whenCreateIteratorHasNextAndNextShouldWorkCorrectly() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("Test");
        simpleArray.add("Test1");
        simpleArray.add("Test2");
        Iterator<String> itr = simpleArray.iterator();
        assertThat(itr.hasNext(), Matchers.is(true));
        assertThat(itr.next(), is("Test"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Test1"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Test2"));
        assertThat(itr.hasNext(), is(false));
    }

}
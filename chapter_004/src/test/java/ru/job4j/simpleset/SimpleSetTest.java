package ru.job4j.simpleset;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * SimpleSetTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleSetTest {
    /**
     * DoubleDataTest.
     */
    @Test
    public void whenAddDoubleDataShouldReturnOne() {
        SimpleSet<String> ss = new SimpleSet<>();
        ss.add("000");
        ss.add("000");
        ss.add("02");
        Iterator it = ss.iterator();
        assertThat(it.next(), is("000"));
        assertThat(it.next(), is("02"));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * All same data return one.
     */
    @Test
    public void whenAddAllSameDataShouldReturnOne() {
        SimpleSet<String> ss = new SimpleSet<>();
        ss.add("000");
        ss.add("000");
        ss.add("000");
        Iterator it = ss.iterator();
        assertThat(it.next(), is("000"));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Correcting date with Integer.
     */
    @Test
    public void whenAddSameIntegerDataShouldReturnCorrectSet() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(new Integer(2));
       // set.forEach(System.out::println);
        Iterator it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

}
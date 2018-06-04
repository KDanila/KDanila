package ru.job4j.tradesystem;

import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Order Test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class OrderTest {
    /**
     * Random Test.
     */
    @Test
    public void orderRandomTest() {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        assertThat(order1.getId(), is(1000));
        assertThat(order2.getId(), is(1001));
        assertThat(order3.getId(), is(1002));

    }
}
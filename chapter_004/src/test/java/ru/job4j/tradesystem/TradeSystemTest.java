package ru.job4j.tradesystem;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * TradeSystemTest.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class TradeSystemTest {
    /**
     * Add DOM.
     */
    @Test
    public void whenAddingOrderAndItIsNotExistShouldCreateDom() {
        TradeSystem tradeSystem = new TradeSystem();
        Order order = new Order();
        order.setBook(111);
        tradeSystem.addOrder(order);
        order.setBook(222);
        tradeSystem.addOrder(order);
        DepthOfMarket dom111 = tradeSystem.getDomArray().get(0);
        DepthOfMarket dom222 = tradeSystem.getDomArray().get(1);
        assertThat(dom111.getId(), is(111));
        assertThat(dom222.getId(), is(222));
    }

}
package ru.job4j.tradesystem;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

public class DepthOfMarketTest {
    @Test
    public void whenAddValuesShouldReturnCorrectlySorted() {
        DepthOfMarket depthOfMarket = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setPrice(10);
        order1.setOrderType(OrderType.ADD);
        Order order2 = new Order();
        order2.setPrice(1);
        order2.setOrderType(OrderType.ADD);
        Order order3 = new Order();
        order3.setPrice(5);
        order3.setOrderType(OrderType.ADD);
        depthOfMarket.add(order1);
        depthOfMarket.add(order2);
        depthOfMarket.add(order3);
        Iterator it = depthOfMarket.iterator();
        assertThat(((Order)it.next()).getPrice(),is(1));
        assertThat(((Order)it.next()).getPrice(),is(5));
        assertThat(((Order)it.next()).getPrice(),is(10));
    }

    /**
     * Тестируем добавление order'а и его удаление, в случае закрытия(OrderType.Delete).
     */
    @Test
    public void whenAddAskOrderShouldAdded(){
        DepthOfMarket dom = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setOrderType(OrderType.ADD);
        order1.setPrice(2);
        dom.add(order1);
        Iterator it = dom.iterator();
        Order expected = (Order) it.next();
        assertThat(expected.getPrice(),is(2));
        assertThat(expected.getOrderType(),is(OrderType.ADD));
        order1.setOrderType(OrderType.DELETE);
        dom.add(order1);
        assertThat(dom.getOrdersSizeInDom(), is(0));

    }
    /**
     * Тестируем добавление order'а на удаление, которого нет.
     */

    @Test(expected = RuntimeException.class)
    public void whenBidOrderShouldReturnError(){
        DepthOfMarket dom = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setOrderType(OrderType.DELETE);
        dom.add(order1);
    }
}
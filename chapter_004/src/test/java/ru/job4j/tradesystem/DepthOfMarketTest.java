package ru.job4j.tradesystem;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class DepthOfMarketTest {
    @Test
    public void whenAddValuesShouldReturnCorrectlySorted() {
        DepthOfMarket depthOfMarket = new DepthOfMarket();
        Order order1 = new Order();
        order1.setPrice(10);
        Order order2 = new Order();
        order2.setPrice(1);
        Order order3 = new Order();
        order3.setPrice(5);
        depthOfMarket.add(order1);
        depthOfMarket.add(order2);
        depthOfMarket.add(order3);
        Iterator it = depthOfMarket.iterator();
        assertThat(((Order)it.next()).getPrice(),is(1));
        assertThat(((Order)it.next()).getPrice(),is(5));
        assertThat(((Order)it.next()).getPrice(),is(10));
    }
}
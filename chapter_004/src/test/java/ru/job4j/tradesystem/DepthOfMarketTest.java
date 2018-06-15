package ru.job4j.tradesystem;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

/**
 * Depth of market test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class DepthOfMarketTest {
    /**
     * First test.
     * testing compareTo.
     */
    @Test
    public void whenAddValuesShouldReturnCorrectlySorted() {
        DepthOfMarket depthOfMarket = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setPrice(10);
        order1.setOrderType(OrderType.ADD);
        Order order2 = new Order();
        order2.setPrice(5);
        order2.setOrderType(OrderType.ADD);
        Order order3 = new Order();
        order3.setPrice(1);
        order3.setOrderType(OrderType.ADD);
        depthOfMarket.add(order1);
        depthOfMarket.add(order2);
        depthOfMarket.add(order3);

        Iterator it = depthOfMarket.iterator();
        //System.out.println(depthOfMarket);
        assertThat(((Order) it.next()).getPrice(), is(10));
        assertThat(((Order) it.next()).getPrice(), is(5));
        assertThat(((Order) it.next()).getPrice(), is(1));
    }

    /**
     * Тестируем добавление order'а и его удаление, в случае закрытия(OrderType.Delete).
     */
    @Test
    public void whenAddAskOrderShouldAdded() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setOrderType(OrderType.ADD);
        order1.setPrice(2);
        dom.add(order1);
        Iterator it = dom.iterator();
        Order expected = (Order) it.next();
        assertThat(expected.getPrice(), is(2));
        assertThat(expected.getOrderType(), is(OrderType.ADD));
        order1.setOrderType(OrderType.DELETE);
        dom.add(order1);
        assertThat(dom.getOrdersSizeInDom(), is(0));

    }

    /**
     * Тестируем добавление order'а на удаление, которого нет.
     */
    @Test(expected = RuntimeException.class)
    public void whenBidOrderShouldReturnError() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setOrderType(OrderType.DELETE);
        dom.add(order1);
    }

    /**
     * Тестируем добавление ордеров на покупку, когда уже есть ордер на продажу с меньшей ценной.
     */
    @Test
    public void whenAddBuyOrderAndBaseHasSameSellOrderShouldSubtractVolume() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order orderBuy = new Order();
        orderBuy.setOrderType(OrderType.ADD);
        orderBuy.setPrice(20);
        orderBuy.setVolume(100);
        orderBuy.setAction(Action.BUY);
        dom.add(orderBuy);
        Order orderSell = new Order();
        orderSell.setOrderType(OrderType.ADD);
        orderSell.setPrice(10);
        orderSell.setVolume(50);
        orderSell.setAction(Action.SELL);
        dom.add(orderSell);
        Iterator it = dom.iterator();
        Order expected = (Order) it.next();
        assertThat(expected.getPrice(), is(20));
        assertThat(expected.getVolume(), is(50));
        assertThat(expected.getAction(), is(Action.BUY));
    }

    /**
     * Тестируем добавление ордеров на покупку, когда уже есть ордер на продажу с меньшей ценной.
     * Объем добавляемого больше.
     */
    @Test
    public void whenAddBuyOrderAndBaseHasSameSellOrderShouldSubtractVolumeSecond() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order orderBuy = new Order();
        orderBuy.setOrderType(OrderType.ADD);
        orderBuy.setPrice(20);
        orderBuy.setVolume(100);
        orderBuy.setAction(Action.BUY);
        dom.add(orderBuy);
        Order orderSell = new Order();
        orderSell.setOrderType(OrderType.ADD);
        orderSell.setPrice(10);
        orderSell.setVolume(200);
        orderSell.setAction(Action.SELL);
        dom.add(orderSell);
        Iterator it = dom.iterator();
        Order expected = (Order) it.next();
        assertThat(expected.getPrice(), is(10));
        assertThat(expected.getVolume(), is(100));
        assertThat(expected.getAction(), is(Action.SELL));
    }

    /**
     * Тестируем добавление ордеров на покупку, когда уже есть ордер на продажу с меньшей ценной.
     * Объемы равные.
     */
    @Test
    public void whenAddBuyOrderAndBaseHasSameSellOrderShouldSubtractVolumeThird() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order orderBuy = new Order();
        orderBuy.setOrderType(OrderType.ADD);
        orderBuy.setPrice(20);
        orderBuy.setVolume(100);
        orderBuy.setAction(Action.BUY);
        dom.add(orderBuy);
        Order orderSell = new Order();
        orderSell.setOrderType(OrderType.ADD);
        orderSell.setPrice(10);
        orderSell.setVolume(100);
        orderSell.setAction(Action.SELL);
        dom.add(orderSell);
        assertThat(dom.getOrdersSizeInDom(), is(0));
    }
}
package ru.job4j.tradesystem;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


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
     * testing add and correctly distribution to buy and sell map.
     */
    @Test
    public void whenAddValuesShouldReturnCorrectlySorted() {
        DepthOfMarket depthOfMarket = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setPrice(10);
        order1.setOrderType(OrderType.ADD);
        order1.setAction(Action.SELL);
        Order order2 = new Order();
        order2.setPrice(5);
        order2.setOrderType(OrderType.ADD);
        order2.setAction(Action.SELL);
        Order order3 = new Order();
        order3.setPrice(1);
        order3.setOrderType(OrderType.ADD);
        order3.setAction(Action.BUY);
        depthOfMarket.add(order1);
        depthOfMarket.add(order2);
        depthOfMarket.add(order3);
        assertThat(depthOfMarket.getSellOrders().get(10D), is(order1));
        assertThat(depthOfMarket.getSellOrders().get(5D), is(order2));
        assertThat(depthOfMarket.getBuyOrders().get(1D), is(order3));
    }

    /**
     * Тестируем добавление order'а и его удаление, в случае закрытия(OrderType.Delete).
     */
    @Test
    public void whenAddAskOrderShouldAdded() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order order1 = new Order();
        order1.setOrderType(OrderType.ADD);
        order1.setAction(Action.BUY);
        order1.setPrice(2);
        dom.add(order1);
        assertThat(dom.getBuyOrders().get(2D), is(order1));
        assertThat(dom.getBuyOrders().get(2D).getOrderType(), is(OrderType.ADD));
        order1.setOrderType(OrderType.DELETE);
        dom.add(order1);
        assertThat(dom.getBuyOrders().size(), is(0));
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
        System.out.println(dom);
        assertThat(dom.getBuyOrders().get(20D), is(orderBuy));
        assertThat(dom.getBuyOrders().get(20D).getVolume(), is(50));
    }

    /**
     * Тестируем добавление ордеров на покупку, когда уже есть ордер на продажу с большей ценной.
     * Объем добавляемого больше.
     */
    @Test
    public void whenAddBuyOrderAndBaseHasSameSellOrderShouldSubtractVolumeSecond() {
        DepthOfMarket dom = new DepthOfMarket(0);
        Order orderBuy = new Order();
        orderBuy.setOrderType(OrderType.ADD);
        orderBuy.setPrice(10);
        orderBuy.setVolume(100);
        orderBuy.setAction(Action.BUY);
        dom.add(orderBuy);
        Order orderSell = new Order();
        orderSell.setOrderType(OrderType.ADD);
        orderSell.setPrice(20);
        orderSell.setVolume(200);
        orderSell.setAction(Action.SELL);
        dom.add(orderSell);
        assertThat(dom.getBuyOrders().get(10D), is(orderBuy));
        assertThat(dom.getSellOrders().get(20D), is(orderSell));
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
        assertThat(dom.getBuyOrders().size(), is(0));
        assertThat(dom.getSellOrders().size(), is(0));
    }
}
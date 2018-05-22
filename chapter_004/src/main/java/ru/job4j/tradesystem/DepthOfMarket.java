package ru.job4j.tradesystem;

import java.util.*;

public class DepthOfMarket implements Iterable<Order> {

    private Set<Order> orders = new TreeSet<>();

    public void add(Order order){
        this.orders.add(order);
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}

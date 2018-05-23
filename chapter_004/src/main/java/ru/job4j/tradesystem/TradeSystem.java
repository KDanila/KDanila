package ru.job4j.tradesystem;

import java.util.ArrayList;
import java.util.List;

public class TradeSystem {

    private List<DepthOfMarket> domArray = new ArrayList<DepthOfMarket>();

    public void addOrder(Order order) {
        int book = order.getBook();
        if (domArray == null || foundEmitentByID(book) == null) {
            domArray.add(new DepthOfMarket(book));
        } else {
            foundEmitentByID(book).add(order);
        }

    }

    private DepthOfMarket foundEmitentByID(int book) {
        DepthOfMarket dom = null;
        for (DepthOfMarket temp : domArray) {
            if (temp.getID() == book) {
                dom = temp;
                break;
            }
        }
        return dom;
    }

    public List<DepthOfMarket> getDomArray() {
        return domArray;
    }

}

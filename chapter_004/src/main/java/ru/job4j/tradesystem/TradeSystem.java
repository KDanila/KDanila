package ru.job4j.tradesystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TradeSystem.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class TradeSystem {
    /**
     * Map of Depth of Markets.
     */
    private Map<Integer, DepthOfMarket> domArray = new HashMap<>();

    /**
     * Add order method.
     *
     * @param order -order.
     */
    public void addOrder(Order order) {
        int book = order.getBook();
        if (!domArray.containsKey(book)) {
            DepthOfMarket dom = new DepthOfMarket(book);
            dom.add(order);
            domArray.put(book, dom);
        } else {
            domArray.get(book).add(order);
        }
    }

    /**
     * getDomArray method.
     *
     * @return - list of depth of market.
     */
    public List<DepthOfMarket> getDomArray() {
        return (List<DepthOfMarket>) domArray.values();
    }
}

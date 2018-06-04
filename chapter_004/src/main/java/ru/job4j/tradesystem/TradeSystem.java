package ru.job4j.tradesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * TradeSystem.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class TradeSystem {
    /**
     * List of Depth of Markets.
     */
    private List<DepthOfMarket> domArray = new ArrayList<DepthOfMarket>();

    /**
     * Add order method.
     *
     * @param order -order.
     */
    public void addOrder(Order order) {
        int book = order.getBook();
        if (domArray == null || foundEmitentByID(book) == null) {
            domArray.add(new DepthOfMarket(book));
        } else {
            foundEmitentByID(book).add(order);
        }

    }

    /**
     * Found emitent by ID method.
     *
     * @param book - int.
     * @return Depth of Market.
     */
    private DepthOfMarket foundEmitentByID(int book) {
        DepthOfMarket dom = null;
        for (DepthOfMarket temp : domArray) {
            if (temp.getId() == book) {
                dom = temp;
                break;
            }
        }
        return dom;
    }

    /**
     * getDomArray method.
     *
     * @return - list of depth of market.
     */
    public List<DepthOfMarket> getDomArray() {
        return domArray;
    }
}

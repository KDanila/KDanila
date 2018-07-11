package ru.job4j.tradesystem;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Depth of market class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class DepthOfMarket {
    /**
     * id.
     */
    private int id;
    /**
     * Buy orders.
     */
    private Map<Double, Order> buyOrders = new TreeMap<>(Comparator.naturalOrder());

    /**
     * Sell orders.
     */
    private Map<Double, Order> sellOrders = new TreeMap<>(Comparator.reverseOrder());

    /**
     * Constructor.
     *
     * @param id - int.
     */
    public DepthOfMarket(int id) {
        this.id = id;
    }

    /**
     * Add method.
     *
     * @param order - to add.
     * @throws RuntimeException - exception.
     */
    public void add(Order order) {
        //1.Проверяем на тип ордера, если закрываем то ищем по таблицам и удаляем от туда.
        if (order.getOrderType() == OrderType.DELETE) {
            if (order.getAction() == Action.BUY) {
                boolean isDelete = buyOrders.remove(order.getPrice(), order);
                //Если нет такого ордера выкидываем ошибку.
                if (!isDelete) {
                    throw new RuntimeException("Can't delete order. Order doesn't exist");
                }
            } else {
                boolean isDelete = sellOrders.remove(order.getPrice(), order);
                if (!isDelete) {
                    throw new RuntimeException("Can't delete order. Order doesn't exist");
                }
            }
        } else {
            //Если тип ордера на добавление, то проверяем на покупку или продажу.
            firstEnty(order);
        }
    }


    /**
     * FirstEnty method.
     * Adding in dom set.
     *
     * @param order - order to add.
     */
    private void firstEnty(Order order) {
        if (order.getAction() == Action.SELL) {
            //Проверяем есть ли цена выше в buy ордерах
            Iterator it = buyOrders.values().iterator();
            if (!it.hasNext()) {
                sellOrders.put(order.getPrice(), order);
            }
            while (it.hasNext()) {
                Order ord = (Order) it.next();
                if (order.getPrice() < ord.getPrice()) {
                    int buyVolume = ord.getVolume();
                    int sellVolume = order.getVolume();
                    if (buyVolume == sellVolume) {
                        buyOrders.remove(ord.getPrice(), ord);
                        break;
                    } else if (buyVolume > sellVolume) {
                        buyOrders.get(ord.getPrice()).setVolume(buyVolume - sellVolume);
                        break;
                    } else if (sellVolume > buyVolume) {
                        order.setVolume(sellVolume - buyVolume);
                    }
                } else {
                    sellOrders.put(order.getPrice(), order);
                    break;
                }
            }
        } else {
            //Проверяем есть ли цена нижу в sell ордерах.
            Iterator it = sellOrders.values().iterator();
            if (!it.hasNext()) {
                buyOrders.put(order.getPrice(), order);
            }
            while (it.hasNext()) {
                Order ord = (Order) it.next();
                if (order.getPrice() > ord.getPrice()) {
                    int buyVolume = order.getVolume();
                    int sellVolume = ord.getVolume();
                    if (buyVolume == sellVolume) {
                        sellOrders.remove(ord.getPrice(), ord);
                        break;
                    } else if (buyVolume < sellVolume) {
                        sellOrders.get(ord.getPrice()).setVolume(buyVolume - sellVolume);
                        break;
                    } else if (sellVolume < buyVolume) {
                        order.setVolume(buyVolume - sellVolume);
                    }
                } else {
                    buyOrders.put(order.getPrice(), order);
                    break;
                }
            }

        }
    }

    @Override
    public String toString() {
        return "DepthOfMarket{"
                + "id=" + id
                + ", buyOrders=" + buyOrders
                + ", sellOrders=" + sellOrders
                + '}';
    }

    /**
     * Buy orders getter.
     *
     * @return - map.
     */
    public Map<Double, Order> getBuyOrders() {
        return buyOrders;
    }

    /**
     * Sell orders getter.
     *
     * @return - map.
     */
    public Map<Double, Order> getSellOrders() {
        return sellOrders;
    }
}

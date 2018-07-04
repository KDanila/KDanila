package ru.job4j.tradesystem;

import java.util.*;

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

    Map<Double, Order> buyOrders = new TreeMap<>(Comparator.naturalOrder());
    Map<Double, Order> sellOrders = new TreeMap<>(Comparator.reverseOrder());

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
    /*public void add(Order order) throws RuntimeException {
        OrderType orderType = order.getOrderType();
        // Берем код эмитента и если нет такого стакана заявок - создаем.
        if (this.id == 0) {
            this.id = order.getBook();
        }
        //По типу заявки выполняем действие.
        if (orderType == OrderType.DELETE) {
            Order orderToRemove = findById(order.getId());
            if (orderToRemove != null) {
                this.orders.remove(orderToRemove.getId());
            } else {
                throw new RuntimeException("Can't delete order");
            }
        } else if (orderType == OrderType.ADD) {
            if (findById(order.getId()) == null) {
                addOrder(order);
            }
        }
    }*/
    public void add(Order order) {
        OrderType orderType = order.getOrderType();
        // Берем код эмитента и если нет такого стакана заявок - создаем.
        if (this.id == 0) {
            this.id = order.getBook();
        }
        //По типу заявки выполняем действие.
        if (orderType == OrderType.DELETE) {
            if (order.getAction() == Action.BUY) {
                this.buyOrders.remove(order);
            } else if ((order.getAction() == Action.SELL)) {
                this.sellOrders.remove(order);
            } else {
                throw new RuntimeException("This order doesn't exist");
            }

        } else if (orderType == OrderType.ADD) {
            if (order.getAction() == Action.BUY) {
                if (!this.buyOrders.containsKey(order)) {
                    firstEnty(order);
                }
            } else if(order.getAction() == Action.SELL){
                if (!this.sellOrders.containsKey(order)) {
                    firstEnty(order);
                }
            } else {
                throw new RuntimeException("Order has no action");
            }
        } else {
            throw new RuntimeException("Order has no order type");
        }
            /*if (findById(order.getId()) == null) {
                addOrder(order);
            }*/
    }



    /**
     * addOrder method.
     * Adding in dom set.
     *
     * @param order - order to add.
     */
    private void firstEnty(Order order) {

        if(order.getAction()==Action.BUY){


        }

        /*Order toModerate = null;
        Order toDeleteFirst = null;
        Order toDeleteSecond = null;
        boolean isEqualVolume = false;
        for (Order ord : this.orders.values()) {
            //Смотрим первую возможность добавляем на покупку, если есть на продажу в стакане, и цена покупки выше, чем цена продажи
            if (order.getAction() == Action.BUY
                    && ord.getAction() == Action.SELL
                    && order.getPrice() > ord.getPrice()
                    ||
                    order.getAction() == Action.SELL
                            && ord.getAction() == Action.BUY
                            && order.getPrice() < ord.getPrice()) {
                //Проверяем на разницу объемов.
                if (order.getVolume() > ord.getVolume()) {
                    toModerate = order;
                    toDeleteFirst = ord;
                    toModerate.setVolume(order.getVolume() - ord.getVolume());
                    break;
                } else if (order.getVolume() < ord.getVolume()) {
                    toModerate = ord;
                    toDeleteFirst = order;
                    toModerate.setVolume(ord.getVolume() - order.getVolume());
                    break;
                } else {
                    toDeleteFirst = order;
                    toDeleteSecond = ord;
                    isEqualVolume = true;
                    break;
                }
            }
        }
        if (toDeleteFirst != null) {
            this.orders.remove(toDeleteFirst.getId());
        }
        if (toDeleteSecond != null) {
            this.orders.remove(toDeleteSecond.getId());
        }
        if (toModerate != null) {
            this.orders.put(toModerate.getId(), toModerate);
        } else if (!isEqualVolume) {
            this.orders.put(order.getId(), order);
        }*/
    }
}

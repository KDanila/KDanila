package ru.job4j.tradesystem;

import java.util.*;

public class DepthOfMarket implements Iterable<Order> {
    private int ID = 0;

    private Set<Order> orders = new TreeSet<>();

    public DepthOfMarket(int ID) {
        this.ID = ID;
    }

    public void add(Order order) throws RuntimeException {
        OrderType orderType = order.getOrderType();
        /**
         * Берем код эмитента и если нет такого стакана заявок - создаем.
         */
        if (this.ID == 0) {
            this.ID = order.getBook();
        }
        //По типу заявки выполняем действие.
        if (orderType == OrderType.DELETE) {
            Order orderToRemove = findById(order.getId());
            if (orderToRemove != null) {
                this.orders.remove(orderToRemove);
            } else {
                throw new RuntimeException("Can't added order");
            }
        } else if (orderType == OrderType.ADD) {
            if (findById(order.getId()) == null) {
                addOrder(order);
            }
        }
    }
//ToDO  проверка заявки если можно уже закрыть из списка ордеров. Покупка и продажа не по рынку.
    private void addOrder(Order order) {
        //Order toModerate = null;
        for (Order ord : this.orders) {
            if(order.getAction()==Action.ASK&&ord.getAction()==Action.BID
                    ||order.getAction()==Action.BID&&ord.getAction()==Action.ASK){

            }
        }
        this.orders.add(order);

    }

    private Order findById(int id) {
        Order order = null;
        for (Order temp : orders) {
            if (temp.getId() == id) {
                order = temp;
                break;
            }
        }
        return order;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return this.orders.toString();
    }

    public int getOrdersSizeInDom() {
        return this.orders.size();
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}
//ToDo 1. Сначала заявки нужно сгруппировать по принципу - покупка. продажа. То есть у вас будет два списка
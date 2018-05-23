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
        if (this.ID == 0) {
            this.ID = order.getBook();
        }
        //Если добавляем и нет такой заявки - добавляем.
        if (orderType==OrderType.ADD&&findById(order.getId())==null) {
            this.orders.add(order);
        } else if(orderType==OrderType.DELETE&&findById(order.getId())!=null){
            this.orders.remove(order);
        } else{
            throw new RuntimeException("Can't added order");
        }


    }

    private Order findById(int id) {
        Order order= null;
        for (Order temp : orders) {
            if(temp.getId()==id){
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

    public int getOrdersSizeInDom(){
        return this.orders.size();
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}
//ToDo 1. Сначала заявки нужно сгруппировать по принципу - покупка. продажа. То есть у вас будет два списка
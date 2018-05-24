package ru.job4j.tradesystem;

import java.util.Objects;

public class Order implements Comparable<Order> {
    /**
     * Ключ заявки начинается с тысячи.
     */
    private int id = 1000;

    private static int orderCounter = 0;
    /**
     * Идентификатор ценной бумаги. Номер имитента.
     */
    private int book;
    /**
     * Тип заявки. Выставление на торги либо снятие.
     */
    private OrderType orderType;
    /**
     * Действие заявки. Покупка или продажа.
     */
    private Action action;
    /**
     * Цена покупки/продажи.
     */
    private int price;
    /**
     * Количество акции покупки/продажи.
     */
    private int volume;

    public Order() {
        this.id += orderCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Order o) {
        return this.price - o.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return (id == order.id &&
                book == order.book);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, book);
    }
}

/**
 * Enumeration OrderType.
 */
enum OrderType {
    ADD, DELETE
}

/**
 * Enumeration Action.
 */
enum Action {
    BID, ASK
}
/*
Заявки двух типов: выставить заявку и убрать с торгов.

Каждая заявки имеет эммитента. Это поле указывает идентификатор ценной бумаги.

Например. Мы ходим купить Акции ГазПрома. Мы посылаем заявку на приобретение акций ГазПрома.

Ниже описание всех полей заявки

id - уникальный ключ заявки.

book - идентификатор ценной бумаги.

type - add/delete - выставить заявку на торги или снять

action - bid/ask - заявка имеет два действия. Заявка на покупка ценной бумаги или на продажу.

price - цена, по которой мы ходим сделать действия покупки или продажи.

volume - количество акций, которые мы хотим продать или купить.
 */
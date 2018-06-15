package ru.job4j.tradesystem;

import java.util.Objects;

/**
 * Order class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Order implements Comparable<Order> {
    /**
     * Ключ заявки начинается с тысячи.
     */
    private int id = 1000;
    /**
     * Счётчик заявок.
     */
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

    /**
     * Constructor.
     */
    public Order() {
        this.id += orderCounter++;
    }

    /**
     * ID getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * ID setter.
     *
     * @param id - int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter Book.
     *
     * @return int book.
     */
    public int getBook() {
        return book;
    }

    /**
     * Setter book.
     *
     * @param book - int.
     */
    public void setBook(int book) {
        this.book = book;
    }

    /**
     * Getter order type.
     *
     * @return order type.
     */
    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * Setter order type.
     *
     * @param orderType -order type.
     */
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    /**
     * Getter action.
     *
     * @return action.
     */
    public Action getAction() {
        return action;
    }

    /**
     * Setter action.
     *
     * @param action - action.
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * Getter price.
     *
     * @return price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter price.
     *
     * @param price - price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter volume.
     *
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setter volume.
     *
     * @param volume - volume.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Compare method.
     * Фильтруем по возрастанию цены.
     *
     * @param o - income order.
     * @return int.
     */
    @Override
    public int compareTo(Order o) {
        return this.price - o.getPrice();
    }

    /**
     * Equals method.
     *
     * @param o - income order.
     * @return true - if equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return (id == order.id && book == order.book);
    }

    /**
     * hashCode method.
     *
     * @return int - hashCode.
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, book);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}

/**
 * Enumeration OrderType.
 */
enum OrderType {
    /**
     * Add and delete types.
     */
    ADD, DELETE
}

/**
 * Enumeration Action.
 */
enum Action {
    /**
     * Sell and buy actions.
     */
    SELL, BUY
}
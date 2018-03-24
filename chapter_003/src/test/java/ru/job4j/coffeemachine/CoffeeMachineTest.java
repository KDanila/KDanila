package ru.job4j.coffeemachine;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * CoffeeMachine class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class CoffeeMachineTest {
    /**
     * The First test.
     */
    @Test
    public void whenValueMoreThenPrice() {
        int value = 50;
        int price = 15;
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.changes(value, price);
        int[] expected = {10, 10, 10, 5};
        assertThat(result, is(expected));
    }

    /**
     * The Second test.
     */
    @Test
    public void whenValueMoreThenPriceTwo() {
        int value = 100;
        int price = 52;
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.changes(value, price);
        int[] expected = {10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(expected));
    }

    /**
     * The Third test.
     */
    @Test
    public void whenValueLessThenPrice() {
        int value = 10;
        int price = 52;
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.changes(value, price);
        int[] expected = {};
        assertThat(result, is(expected));
    }

    /**
     * The Fourth test.
     */
    @Test
    public void whenValueMoreThenPriceThree() {
        int value = 100;
        int price = 1;
        CoffeeMachine cm = new CoffeeMachine();
        int[] result = cm.changes(value, price);
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 2, 2};
        assertThat(result, is(expected));
    }

}
package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculator Class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test Add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test Subtract.
     */
    @Test
    public void whenSubtractTenMinusNineThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(10D, 9D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test Divide.
     */
    @Test
    public void whenDivSixDivideTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
    /**
     * Test Multiple.
     */
    @Test
    public void whenMultipleSixAndThreeThenEighteen() {
        Calculator calc = new Calculator();
        calc.multiple(6D, 3D);
        double result = calc.getResult();
        double expected = 18D;
        assertThat(result, is(expected));
    }
}

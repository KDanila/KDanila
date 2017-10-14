package ru.job4j.calculator;

/**
 * Calculator.
 * result - result of calculation.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * result of operation.
     */
    private double result;

    /**
     * Method add.
     *
     * @param first  number.
     * @param second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     *
     * @param first  number.
     * @param second number.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     *
     * @param first  number.
     * @param second number.
     */

    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     *
     * @param first  number.
     * @param second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     *
     * @return Calculator operation
     */

    public double getResult() {
        return this.result;
    }
}

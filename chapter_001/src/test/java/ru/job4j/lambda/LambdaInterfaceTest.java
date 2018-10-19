package ru.job4j.lambda;

import org.junit.Test;

public class LambdaInterfaceTest {
    @Test
    public void whenLineFunctionThenReturnTrue() {
        MathFunction mf = new MathFunction();

        System.out.println(mf.diapason(0,10,(x)->2*x));
    }

    @Test
    public void whenSquareFunctionThenReturnTrue() {
        MathFunction mf = new MathFunction();

        System.out.println(mf.diapason(0,10,(x)->Math.pow(x,2)));
    }

    @Test
    public void whenLogariphmFunctionThenReturnTrue() {
        MathFunction mf = new MathFunction();

        System.out.println(mf.diapason(0,10,Math::log));
    }
}
package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
* Test.
*
* @author Kuzmin Danila (mailto:bus1d0@mail.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Danila Kuzmin";
    String expect = "Echo, echo, echo : Danila Kuzmin";
	Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
}
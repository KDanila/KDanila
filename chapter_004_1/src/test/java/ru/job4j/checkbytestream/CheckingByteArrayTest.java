package ru.job4j.checkbytestream;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * CheckingByteArrayTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CheckingByteArrayTest {
    /**
     * Test1.
     */
    @Test
    public void ifIsNumberEvenShouldReturnTrue() {
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        CheckingByteArray checkingByteArray = new CheckingByteArray();
        boolean state = checkingByteArray.isNumber(in);
        assertThat(state, is(true));
    }

    /**
     * Test2.
     */
    @Test
    public void ifIsNumberOddShouldReturnFalse() {
        ByteArrayInputStream in = new ByteArrayInputStream("771".getBytes());
        CheckingByteArray checkingByteArray = new CheckingByteArray();
        boolean state = checkingByteArray.isNumber(in);
        assertThat(state, is(false));
    }

}
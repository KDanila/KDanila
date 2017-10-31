package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Turn Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
    /**
     * Test {1,2,3,4,5}----->{5,4,3,2,1}.
     */
    @Test
    public void whenFiveNumbersThenTurnFive() {
        Turn turn = new Turn();
        int[] expectedArray = {5, 4, 3, 2, 1};
        int[] startArray = {1, 2, 3, 4, 5};
        int[] resultArray = turn.back(startArray);
        assertThat(resultArray, is(expectedArray));
    }

    /**
     * Test {4,1,6,2}----->{2,6,1,4}.
     */
    public void whenFourNmbersThenTurnFour() {
        Turn turn = new Turn();
        int[] expectedArray = {2, 6, 1, 4};
        int[] startArray = {4, 1, 6, 2};
        int[] resultArray = turn.back(startArray);
        assertThat(resultArray, is(expectedArray));
    }

}

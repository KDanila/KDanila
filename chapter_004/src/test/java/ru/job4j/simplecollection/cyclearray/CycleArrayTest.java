package ru.job4j.simplecollection.cyclearray;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * CycleArrayTest.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CycleArrayTest {
    /**
     * The first test.
     * Node has cycle -----> true.
     */
    @Test
    public void whenCreateFourNodeWithCycleShouldReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        CycleArray ca = new CycleArray();
        boolean result = ca.hasCycle(first);
        assertThat(result, is(true));
    }

    /**
     * The second test.
     * Node hasn't cycle -----> false.
     */
    @Test
    public void whenCreateFourNodeWithOutCycleShouldReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);


        CycleArray ca = new CycleArray();
        boolean result = ca.hasCycle(first);
        assertThat(result, is(false));
    }

}
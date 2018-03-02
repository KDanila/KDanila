package ru.job4j.queue;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Queue test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class PriorityQueueTest {
    /**
     * First test.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * Second test.
     */
    @Test
    public void whenThreeHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> expected = new LinkedList<String>();
        result.add(queue.take().getDesc());
        result.add(queue.take().getDesc());
        result.add(queue.take().getDesc());
        result.add(queue.take().getDesc());
        expected.add("urgent");
        expected.add("urgent");
        expected.add("urgent");
        expected.add("middle");
        assertThat(result, is(expected));
    }

    /**
     * Third test.
     */
    @Test
    public void whenTasksStayConversaly() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> expected = new LinkedList<String>();
        result.add(queue.take().getDesc());
        result.add(queue.take().getDesc());
        result.add(queue.take().getDesc());
        expected.add("urgent");
        expected.add("middle");
        expected.add("low");
        assertThat(result, is(expected));

    }
}
package ru.job4j.waitandnotify;

import org.junit.Test;

/**
 * SimpleBlockingQueue class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleBlockingQueueTest {
    /**
     * Test method.
     *
     * @throws InterruptedException - ie exception.
     */
    @Test
    public void whenOfferAndPollValueShouldCorrectWork() throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>(10);
        Customer<Integer> customer = new Customer<>(sbq);
        IntegerProducer iProducer = new IntegerProducer(sbq);
        Thread customerThread = new Thread(customer);
        Thread producerThread = new Thread(iProducer);
        customerThread.start();
        producerThread.start();
    }
}
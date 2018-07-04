package ru.job4j.waitandnotify;

import org.junit.Test;


public class SimpleBlockingQueueTest {

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
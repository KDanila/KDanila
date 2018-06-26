package ru.job4j.waitandnotify;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void offerTest() throws InterruptedException {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue();
        Thread producerOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread producerTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread producerThree = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerOne.start();
        producerTwo.start();
        producerThree.start();
        producerOne.join();
        producerTwo.join();
        producerThree.join();
        System.out.println(simpleBlockingQueue);
        Thread consumerOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumerOne.start();
        consumerOne.join();
        System.out.println(simpleBlockingQueue);
    }

}
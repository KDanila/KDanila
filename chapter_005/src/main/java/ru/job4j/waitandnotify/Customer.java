package ru.job4j.waitandnotify;

public class Customer<T> implements Runnable {
    private SimpleBlockingQueue<T> sbq;

    public Customer(SimpleBlockingQueue sbq) {
        this.sbq = sbq;
    }

    @Override
    public void run() {

        try {
            System.out.println(sbq.poll());
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

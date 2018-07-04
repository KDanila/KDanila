package ru.job4j.waitandnotify;

public class IntegerProducer implements Runnable {
    private SimpleBlockingQueue sbq ;

    IntegerProducer(SimpleBlockingQueue sbq){
        this.sbq = sbq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            try {
                sbq.offer(i);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

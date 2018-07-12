package ru.job4j.waitandnotify;

/**
 * IntegerProducer class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class IntegerProducer implements Runnable {
    /**
     * Blocking queue.
     */
    private SimpleBlockingQueue sbq;

    /**
     * Constructor.
     *
     * @param sbq - blocking queue.
     */
    IntegerProducer(SimpleBlockingQueue sbq) {
        this.sbq = sbq;
    }

    /**
     * Run method.
     */
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

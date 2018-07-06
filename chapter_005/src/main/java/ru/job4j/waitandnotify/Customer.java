package ru.job4j.waitandnotify;

/**
 * Customer class.
 *
 * @param <T>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Customer<T> implements Runnable {
    /**
     * Blocking queue.
     */
    private SimpleBlockingQueue<T> sbq;

    /**
     * Constructor.
     *
     * @param sbq - blocking queue.
     */
    public Customer(SimpleBlockingQueue sbq) {
        this.sbq = sbq;
    }

    /**
     * Run method.
     */
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

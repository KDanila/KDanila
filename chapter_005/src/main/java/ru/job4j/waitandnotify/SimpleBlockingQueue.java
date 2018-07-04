package ru.job4j.waitandnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;


/**
 * SimpleBlockingQueue class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
@ThreadSafe
class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private int maxSize;

    /**
     * Constructor.
     *
     * @param maxSize Max size.
     */
    public SimpleBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Add value.
     *
     * @param value Value.
     */
    public synchronized void offer(T value) {
        while (this.queue.size() == this.maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(value);
        notifyAll();
    }

    /**
     * Take element
     *
     * @return
     */
    public synchronized T poll() {
        while (this.queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return this.queue.poll();
    }

}
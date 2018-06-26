package ru.job4j.waitandnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    private final Object consumerLock = new Object();
    private final Object producerLock = new Object();
    private boolean blockConsumer = false;
    private boolean blockProducer = false;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    /**
     * Добавляем элемент.
     *
     * @param value
     * @throws InterruptedException
     */
    public void offer(T value) throws InterruptedException {
        synchronized (producerLock) {
            blockProducer = !this.queue.offer(value);
            System.out.println("block producer " + blockProducer);
            if (!blockProducer) {
                System.out.println("consumer notify");
                //consumerLock.notify();
            } else {
                while (blockProducer) {
                    System.out.println("wait offer");
                    producerLock.wait();
                }
                System.out.println("offer after block producer");
                this.queue.offer(value);
            }
        }
    }

    public T poll() throws InterruptedException {
        synchronized (consumerLock) {
            T temp = this.queue.peek();
            System.out.println(temp);
            if (temp == null) {
                blockConsumer = true;
                return null;
            } else {
                System.out.println("Producer notify");
                //producerLock.notify();
                while (blockConsumer) {
                    System.out.println("block consumer");
                    consumerLock.wait();
                }
                return this.queue.poll();
            }
        }
    }

    @Override
    public String toString() {
        return "SimpleBlockingQueue{" +
                "queue=" + queue +
                '}';
    }
}

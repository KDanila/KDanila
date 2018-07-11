package ru.job4j.pool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ThreadPool class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
@ThreadSafe
public class ThreadPool {
    /**
     * Threads.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * Tasks of runnable.
     */
    @GuardedBy("this")
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    /**
     * Size - number of available processors.
     */
    private final int size = Runtime.getRuntime().availableProcessors();

    /**
     * Constructor.
     * Initialising new thread for each task.
     */
    public ThreadPool() {
        for (int i = 0; i < size; i++) {
            threads.add(new Thread(() -> {
                while (tasks.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tasks.poll().run();
            }));
            threads.get(i).start();
        }
    }

    /**
     * Add job method.
     *
     * @param job - runnable.
     */
    public synchronized void work(Runnable job) {
        tasks.offer(job);
        notifyAll();
    }

    /**
     * Shutdown method.
     * Close all threads.
     */
    public void shutdown() {
        for (int i = 0; i < size; i++) {
            threads.get(0).interrupt();
        }
    }
}

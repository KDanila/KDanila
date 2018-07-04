package ru.job4j.pool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    @GuardedBy("this")
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    int size = Runtime.getRuntime().availableProcessors();

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

    public void work(Runnable job) {
        tasks.offer(job);
        notifyAll();
    }

    public void shutdown() {

    }
}

package ru.job4j.jmm;

/**
 * ThreadProblemExample class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class ThreadProblemExample {
    /**
     * Main method.
     *
     * @param args - arguments.
     */
    public static void main(String[] args) {
        CounterClass cc = new CounterClass();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    cc.add(1);
                    System.out.println(cc.getCount() + " " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread one = new Thread(runnable, "поток 1");
        Thread two = new Thread(runnable, "поток 2");
        Thread three = new Thread(runnable, "поток 3");
        Thread four = new Thread(runnable, "поток 4");
        one.start();
        two.start();
        three.start();
        four.start();
    }
}


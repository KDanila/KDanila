package ru.job4j.monitoreandsynchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Count class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
@ThreadSafe
public class Count {
    /**
     * value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * increment method.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * get method.
     *
     * @return value.
     */
    public synchronized int get() {
        return this.value;
    }
}

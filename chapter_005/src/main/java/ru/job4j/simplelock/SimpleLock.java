package ru.job4j.simplelock;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * SimpleLock class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
@ThreadSafe
public class SimpleLock {
    /**
     * isLock - заблокирован ли поток.
     */
    @GuardedBy("this")
    private boolean isLock;

    /**
     * Lock method.
     * Проверяет свободен ли лок? Если да - захватывает, иначе блокируется.
     */
    public void lock() {
        while (isLock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isLock = true;
    }

    /**
     * Unlock method.
     * Проверяет владеет ли поток локом? Если да то - освобождает.
     */
    public void unlock() {
        this.isLock = false;
        notifyAll();
    }
}
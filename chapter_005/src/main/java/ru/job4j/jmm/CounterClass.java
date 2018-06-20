package ru.job4j.jmm;

/**
 * CounterClass class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CounterClass {
    /**
     * Count.
     */
    private long count = 0;

    /**
     * Add method.
     *
     * @param value - value.
     */
    public void add(long value) {
        this.count = this.count + value;
    }

    /**
     * Getter.
     *
     * @return long.
     */
    public long getCount() {
        return count;
    }


}

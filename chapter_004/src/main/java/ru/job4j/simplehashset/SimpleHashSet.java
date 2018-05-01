package ru.job4j.simplehashset;


import java.util.Arrays;

/**
 * SimpleHashSet class.
 *
 * @param <E>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleHashSet<E> {
    /**
     * As standart here is 128 groups.
     */
    private int numberOfGroup;
    /**
     * Objects data.
     */
    private Object[] objects;
    /**
     * Size.
     */
    private int size = 0;

    /**
     * Constructor.
     */
    SimpleHashSet() {
        this.numberOfGroup = 128;
        objects = new Object[128];
    }

    /**
     * Метод Add  с линейным пробированием.
     *
     * @param e - E generic.
     * @return boolean always add becouse before adding checking array filling.
     */
    public boolean add(E e) {
        int hash = hashKey(e);
        if (size / numberOfGroup > 0.5) {
            this.objects = increaseArray();
        }
        while (this.objects[hash] != null) {
            hash++;
            hash %= this.objects.length;
        }
        this.objects[hash] = e;
        return true;
    }

    /**
     * Method increasing array.
     *
     * @return objects X 2.
     */
    private Object[] increaseArray() {
        return Arrays.copyOf(this.objects, this.objects.length * 2);
    }

    /**
     * Contains method.
     *
     * @param e - E generic.
     * @return contains or not objects element.
     */
    boolean contains(E e) {
        boolean isContains = false;
        int hash = hashKey(e);
        while (this.objects[hash] != null) {
            if (hashKey((E) this.objects[hash]) == hash) {
                isContains = true;
                break;
            }
            hash++;
            hash %= this.objects.length;
        }
        return isContains;
    }

    /**
     * Remove method.
     *
     * @param e - E generic.
     * @return boolean - return true if delete element.
     */
    boolean remove(E e) {
        boolean isRemove = false;
        int hash = hashKey(e);
        while (this.objects[hash] != null) {
            if (hashKey((E) this.objects[hash]) == hash) {
                isRemove = true;
                this.objects[hash] = null;
                break;
            }
            hash++;
            hash %= this.objects.length;
        }
        return isRemove;
    }

    /**
     * Method to find hashKey.
     *
     * @param e -E generic.
     * @return - return hash.
     */
    private int hashKey(E e) {
        return e.hashCode() % this.numberOfGroup;
    }
}
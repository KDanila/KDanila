package ru.job4j.simplecollection.simplehashset;


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
     * Objects data.
     */
    private Object[] objects;
    /**
     * Null element.
     */
    private final NullElement nullElement = new NullElement();
    /**
     * Size.
     */
    private int size = 0;

    /**
     * Constructor. Initial length 128.
     */
    SimpleHashSet() {
        objects = new Object[128];
    }

    /**
     * Overload constructor(you can change size).
     *
     * @param size - int size of array.
     */
    SimpleHashSet(int size) {
        objects = new Object[size];
    }

    /**
     * Метод Add  с линейным пробированием.
     *
     * @param e - E generic.
     * @return boolean always add becouse before adding checking array filling.
     */
    public boolean add(E e) {
        int hash = hashKey(e);
        if ((double) size / (double) this.objects.length >= 0.5) {
            this.objects = increaseArray();
        }
        while (this.objects[hash] != null) {
            if (this.objects[hash] == nullElement) {
                break;
            }
            hash++;
            hash %= this.objects.length;
        }
        if (this.objects[hashKey(e)] == null
                || this.objects[hash] == nullElement
                || !(this.objects[hashKey(e)].equals(e))) {
            this.objects[hash] = e;
            size++;
        }

        return true;
    }

    /**
     * Method increasing array.
     *
     * @return objects X 2.
     */
    private Object[] increaseArray() {
        int newObjectSize = this.objects.length * 2;
        Object[] temp = this.objects;
        this.objects = new Object[newObjectSize];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                add((E) temp[i]);
                size--;
            }
        }
        return this.objects;
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
            } else if (this.objects[hash] == nullElement) {
                isContains = false;
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
            if (hashKey((E) this.objects[hash]) == hash && this.objects[hash].equals(e)) {
                isRemove = true;
                this.objects[hash] = nullElement;
                size--;
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
        return Math.abs(e.hashCode() % this.objects.length);
    }

    /**
     * Overload hasKey method.
     *
     * @param e      - E.
     * @param length - length of new array.
     * @return int - hashkey.
     */
    private int hashKey(E e, int length) {
        return Math.abs(e.hashCode() % length);
    }

    /**
     * To testing increasing method.
     *
     * @return length of array.
     */
    public int getHashSetLength() {
        return this.objects.length;
    }

    /**
     * Null Element class.
     */
    public class NullElement extends Object {
    }

}
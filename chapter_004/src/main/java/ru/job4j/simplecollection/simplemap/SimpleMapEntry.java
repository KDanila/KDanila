package ru.job4j.simplecollection.simplemap;

/**
 * SimpleMapEntry class.
 *
 * @param <K> - key.
 * @param <V> - value.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SimpleMapEntry<K, V> {
    /**
     * Key.
     */
    private K key;
    /**
     * Value.
     */
    private V value;

    /**
     * Constructor.
     *
     * @param key   - key.
     * @param value - value.
     */
    public SimpleMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Key Getter.
     *
     * @return K - key.
     */
    public K getKey() {
        return key;
    }

    /**
     * Value Getter.
     *
     * @return V - value.
     */
    public V getValue() {
        return value;
    }
}

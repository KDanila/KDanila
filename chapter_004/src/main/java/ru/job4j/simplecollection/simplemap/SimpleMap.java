package ru.job4j.simplecollection.simplemap;


/**
 * SimpleHashSet class.
 *
 * @param <K> - key.
 * @param <V> - value.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SimpleMap<K, V> {
    /**
     * keys array.
     */
    private Object[] keys;
    /**
     * values array.
     */
    private Object[] values;
    /**
     * number of elements.
     */
    private int size = 0;

    /**
     * Constructor.
     */
    public SimpleMap() {
        this.keys = new Object[128];
        this.values = new Object[128];
    }

    /**
     * Overload constructor.
     *
     * @param size - size.
     */
    public SimpleMap(int size) {
        this.keys = new Object[size];
        this.values = new Object[size];
    }


    /**
     * Insert method.
     * Не разрешаем коллизии никак.
     * Если при добавлении ключ уже есть, то возвращать false.
     *
     * @param key   - key.
     * @param value - value.
     * @return boolean.
     */
    boolean insert(K key, V value) {
        int hash = hashKey(key);
        boolean isInsert = false;
        if ((double) size / (double) this.keys.length >= 0.5) {
            increaseArray();
        }
        if (this.keys[hash] == null) {
            this.keys[hash] = key;
            this.values[hash] = value;
            isInsert = true;
            this.size++;
        }
        return isInsert;
    }

    /**
     * Get method.
     *
     * @param key - key.
     * @return V - value.
     */
    V get(K key) {
        int hash = hashKey(key);
        Object value = null;
        if (this.keys[hash] != null) {
            value = this.values[hash];
        }
        return (V) value;
    }

    /**
     * Delete method.
     *
     * @param key - key.
     * @return boolean.
     */
    boolean delete(K key) {
        int hash = hashKey(key);
        boolean isDelete = false;
        if (this.keys[hash] != null) {
            this.keys[hash] = null;
            this.values[hash] = null;
            isDelete = true;
            this.size--;
        }
        return isDelete;
    }

    /**
     * Method increasing array.
     */
    private void increaseArray() {
        int newObjectSize = this.keys.length * 2;
        Object[] tempKeys = this.keys;
        Object[] tempValues = this.values;
        this.keys = new Object[newObjectSize];
        this.values = new Object[newObjectSize];
        for (int i = 0; i < tempKeys.length; i++) {
            if (tempKeys[i] != null) {
                insert((K) tempKeys[i], (V) tempValues[i]);
                size--;
            }
        }
    }

    /**
     * hashKey method. Распределяет кэш по длине массива.
     *
     * @param key - key.
     * @return hash.
     */
    private int hashKey(K key) {
        return key.hashCode() % this.keys.length;
    }

    /**
     * For Simple Map test.
     *
     * @return size of arrays.
     */
    public int getSize() {
        return this.keys.length;
    }

}
/*
Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
boolean insert(K key, V value);
V get(K key);
boolean delete(K key);

Реализовывать итератор.
Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение.
Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.

Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 */
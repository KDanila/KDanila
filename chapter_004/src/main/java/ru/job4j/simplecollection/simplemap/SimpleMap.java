package ru.job4j.simplecollection.simplemap;

/**
 * SimpleMap class.
 *
 * @param <K> - key.
 * @param <V> - value.
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public class SimpleMap<K, V> {
    /**
     * Entry objects.
     */
    private SimpleMapEntry<K, V>[] objects;
    /**
     * number of elements.
     */
    private int size = 0;

    /**
     * Constructor.
     */
    public SimpleMap() {
        this.objects = new SimpleMapEntry[128];
    }

    /**
     * Overload constructor.
     *
     * @param size - size.
     */
    public SimpleMap(int size) {
        this.objects = new SimpleMapEntry[size];
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
        if ((double) size / (double) this.objects.length >= 0.5) {
            increaseArray();
        }
        if (this.objects[hash] == null) {
            this.objects[hash] = new SimpleMapEntry<>(key, value);
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
        V value = null;
        if (this.objects[hash] != null) {
            value = this.objects[hash].getValue();
        }
        return value;
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
        if (this.objects[hash] != null) {
            this.objects[hash] = null;
            isDelete = true;
            this.size--;
        }
        return isDelete;
    }

    /**
     * Method increasing array.
     */
    private void increaseArray() {
        int newObjectSize = this.objects.length * 2;
        SimpleMapEntry<K, V>[] tempObjects = this.objects;
        this.objects = new SimpleMapEntry[newObjectSize];
        for (int i = 0; i < tempObjects.length; i++) {
            if (tempObjects[i] != null) {
                insert(tempObjects[i].getKey(), tempObjects[i].getValue());
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
        return key.hashCode() % this.objects.length;
    }

    /**
     * For Simple Map test.
     *
     * @return size of arrays.
     */
    public int getSize() {
        return this.objects.length;
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
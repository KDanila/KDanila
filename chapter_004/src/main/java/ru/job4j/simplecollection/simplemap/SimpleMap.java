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
     * Insert method.
     *
     * @param key   - key.
     * @param value - value.
     * @return boolean.
     */
    boolean insert(K key, V value) {
        return true;
    }

    /**
     * Get method.
     *
     * @param key - key.
     * @return V - value.
     */
    V get(K key) {
        return null;
    }

    /**
     * Delete method.
     *
     * @param key - key.
     * @return boolean.
     */
    boolean delete(K key) {
        return false;
    }
}
/*
Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
boolean insert(K key, V value);
V get(K key);
boolean delete(K key);

Реализовывать итератор.
Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.

Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 */
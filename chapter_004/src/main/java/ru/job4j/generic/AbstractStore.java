package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

/**
 * AbstractStore class.
 *
 * @param <T>
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */

public abstract class AbstractStore<T extends Base> {
    /**
     * Array of store data, based on simplearray.
     */
    private SimpleArray<T> roleStoreData;

    /**
     * Constructor.
     *
     * @param size .
     */
    protected AbstractStore(int size) {
        this.roleStoreData = new SimpleArray<>(size);
    }

    /**
     * Add method.
     *
     * @param model - model.
     */
    public void add(T model) {
        this.roleStoreData.add(model);
    }

    /**
     * Replace method.
     *
     * @param id    - id.
     * @param model - model.
     * @return true if replace.
     */
    public boolean replace(String id, T model) {
        boolean toReturn = false;
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.set(position, model);
            toReturn = true;
        }
        return toReturn;
    }

    /**
     * Delete method.
     *
     * @param id - id.
     * @return true if delete.
     * @throws Exception - exception.
     */
    public boolean delete(String id) throws Exception {
        boolean toReturn = false;
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.delete(position);
            toReturn = true;
        }
        return toReturn;
    }

    /**
     * Find by id method.
     *
     * @param id - id.
     * @return base class.
     */
    public Base findById(String id) {
        int position = findPositionByID(id);
        Base toReturn = null;
        if (position == -1) {
            toReturn = this.roleStoreData.get(position);
        }
        return toReturn;
    }

    /**
     * Find by id method if position doesn't find return -1.
     *
     * @param id - id in String format.
     * @return int -position.
     */
    public int findPositionByID(String id) {
        Iterator<T> iterator = this.roleStoreData.iterator();
        int counter = 0;
        int toReturn = -1;
        while (iterator.hasNext()) {
            Base temp = iterator.next();
            if (temp.getId().equals(id)) {
                toReturn = counter;
                break;
            }
            counter++;
        }
        return toReturn;
    }
}

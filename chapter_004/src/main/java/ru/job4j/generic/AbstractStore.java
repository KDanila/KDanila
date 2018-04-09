package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base>{

    private SimpleArray<T> roleStoreData ;

    protected AbstractStore(int size) {
        this.roleStoreData = new SimpleArray<>(size);
    }


    public void add(T model) {
        this.roleStoreData.add(model);
    }


    public boolean replace(String id, T model) {
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.set(position, model);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) throws Exception {
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.delete(position);
            return true;
        } else {
            return false;
        }
    }

    public Base findById(String id) {
        int position = findPositionByID(id);
        if (position == -1) {
            return this.roleStoreData.get(position);
        } else {
            return null;
        }
    }

    /**
     * Find by id method if position doesn't find return -1;
     *
     * @param id - id in String format.
     * @return int -position.
     */
    public int findPositionByID(String id) {
        Iterator<T> iterator = this.roleStoreData.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            Base temp = iterator.next();
            if (temp.getId().equals(id)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }
}

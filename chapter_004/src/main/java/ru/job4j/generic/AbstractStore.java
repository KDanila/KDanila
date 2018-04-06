package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

public abstract class AbstractStore implements Store<Base>{

    private SimpleArray<Base> roleStoreData ;

    protected AbstractStore(int size) {
        this.roleStoreData = new SimpleArray<>(size);
    }

    @Override
    public void add(Base model) {
        this.roleStoreData.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.set(position, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.delete(position);
            return true;
        } else {
            return false;
        }
    }

    @Override
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
        Iterator<Base> iterator = this.roleStoreData.iterator();
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

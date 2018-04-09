package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

public class RoleStore implements Store {
    private SimpleArray<Role> roleStoreData = new SimpleArray(10);

    @Override
    public void add(Base model) {
        this.roleStoreData.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int position = findPositionByID(id);
        if (position == -1) {
            this.roleStoreData.set(position, (Role) model);
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
            return (Base) this.roleStoreData.get(position);
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
        Iterator<Role> iterator =  this.roleStoreData.iterator();
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

package ru.job4j.nonblocking;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Non blocking class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class NonBlocking {
    /**
     * Data.
     */
    private ConcurrentHashMap<Integer, Base> data = new ConcurrentHashMap<>();

    /**
     * Add method.
     *
     * @param model - base type.
     */
    public void add(Base model) {
        data.putIfAbsent(model.hashCode(), model);
    }

    /**
     * Update method.
     *
     * @param model - base type.
     */
    public void update(Base model) {
        data.computeIfPresent(model.getId(), (id, base) -> {
            if (base.getVersion() == model.getVersion()) {
                base.setName(model.getName());
                model.modifyVersion();
            } else {
                throw new OptimisticException("Version is not same!");
            }
            return model;
        });
        model.modifyVersion();
    }

    /**
     * Delete method.
     *
     * @param model - base type.
     */
    public void delete(Base model) {
        data.remove(model.hashCode(), model);
    }
}

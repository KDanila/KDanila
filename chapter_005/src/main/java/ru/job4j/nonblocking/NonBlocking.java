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
        int currentVersion = model.getVersion();
        data.putIfAbsent(model.hashCode(), model);
        checkActualInformation(model.getVersion(), currentVersion);
        model.modifyVersion();
    }

    /**
     * Update method.
     *
     * @param model - base type.
     */
    public void update(Base model) {
        int currentVersion = model.getVersion();
        data.computeIfPresent(model.getId(), (id, base) -> {
            if (base.getVersion() == model.getVersion()) {
                base.setName(model.getName());
            }
            return model;
        });
        checkActualInformation(model.getVersion(), currentVersion);
        model.modifyVersion();
    }

    /**
     * Delete method.
     *
     * @param model - base type.
     */
    public void delete(Base model) {
        data.remove(model.hashCode(), model);
        model.modifyVersion();
    }

    /**
     * Check actual information method.
     * If entries was modified method throws OptimisticException.
     *
     * @param version - previous version.
     * @param currentVersion - current version.
     * @throws OptimisticException - oe.
     */
    public void checkActualInformation(int version, int currentVersion) throws OptimisticException {
        if (version != currentVersion) {
            throw new OptimisticException("Version is not same!");
        }
    }
}

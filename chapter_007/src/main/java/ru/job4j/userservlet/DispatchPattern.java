package ru.job4j.userservlet;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.function.BiFunction;

public class DispatchPattern {
    /**
     * Contains destinations.
     */
    private final Map<Action.StoreAction, BiFunction<Store, User, Boolean>> dispatch = new HashMap<>();


    public BiFunction<Store, User, Boolean> toAdd() {
        return (store, user) -> {
            store.add(user);
            return true;
        };
    }

    public BiFunction<Store, User, Boolean> toDelete() {
        return (store, user) -> {
            store.delete(user);
            return true;
        };
    }

    public BiFunction<Store, User, Boolean> toUpdate() {
        return (store, user) -> {
            store.update(user);
            return true;
        };
    }


    /**
     * Init's dispatch.
     *
     * @return current object.
     */
    public DispatchPattern init() {
        this.load(Action.StoreAction.ADD, this.toAdd());
        this.load(Action.StoreAction.UPDATE, this.toUpdate());
        this.load(Action.StoreAction.DELETE, this.toDelete());
        return this;
    }


    public void load(Action.StoreAction storeAction, BiFunction<Store, User, Boolean> handle) {
        this.dispatch.put(storeAction, handle);
    }


    public boolean action(final Action storeAction, final Store store, final User user) {
        return this.dispatch.get(
                storeAction.type()).apply(store, user);
    }

}

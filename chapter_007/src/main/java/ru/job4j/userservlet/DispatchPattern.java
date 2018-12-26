package ru.job4j.userservlet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * DispatchPattern class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class DispatchPattern {
    /**
     * Contains destinations.
     */
    private final Map<Action.StoreAction, BiFunction<ValidateService, User, Boolean>> dispatch = new HashMap<>();

    /**
     * toAdd method.
     *
     * @return functional interface <ValidateService, User, Boolean>.
     */
    public BiFunction<ValidateService, User, Boolean> toAdd() {
        return (validateService, user) -> {
            validateService.add(user);
            return true;
        };
    }

    /**
     * toDelete method.
     *
     * @return functional interface <ValidateService, User, Boolean>.
     */
    public BiFunction<ValidateService, User, Boolean> toDelete() {
        return (validateService, user) -> {
            validateService.delete(user);
            return true;
        };
    }

    /**
     * toUpdate method.
     *
     * @return functional interface <ValidateService, User, Boolean>.
     */
    public BiFunction<ValidateService, User, Boolean> toUpdate() {
        return (validateService, user) -> {
            //validateService.update(user);
            return true;
        };
    }


    /**
     * Initialise dispatch methods.
     *
     * @return current object.
     */
    public DispatchPattern init() {
        this.load(Action.StoreAction.ADD, this.toAdd());
        this.load(Action.StoreAction.UPDATE, this.toUpdate());
        this.load(Action.StoreAction.DELETE, this.toDelete());
        return this;
    }

    /**
     * load method.
     * Created for loading possible methods.
     *
     * @param storeAction - possible action.
     * @param handle - bifunction interface.
     */
    public void load(Action.StoreAction storeAction, BiFunction<ValidateService, User, Boolean> handle) {
        this.dispatch.put(storeAction, handle);
    }

    /**
     * action method.
     *
     * Make action on logic layout(validate service).
     *
     * @param storeAction - actions.
     * @param validateService - validate service.
     * @param user - user.
     * @return boolean.
     */
    public boolean action(final Action storeAction, final ValidateService validateService, final User user) {
        return this.dispatch.get(
                storeAction.type()).apply(validateService, user);
    }

}

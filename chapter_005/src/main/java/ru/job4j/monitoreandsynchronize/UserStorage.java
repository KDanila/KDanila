package ru.job4j.monitoreandsynchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * UserStorage class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
@ThreadSafe
public class UserStorage {
    /**
     * user data.
     */
    @GuardedBy("this")
    private Map<Integer, User> usersData = new HashMap<>();

    /**
     * Add method.
     *
     * @param user - user.
     * @return boolean - true if added.
     */
    public synchronized boolean add(User user) {
        if (!usersData.containsKey(user.getId())) {
            usersData.put(user.getId(), user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update method.
     *
     * @param user - user.
     * @return boolean - true if updated.
     */
    public synchronized boolean update(User user) {
        if (usersData.containsKey(user.getId())) {
            usersData.put(user.getId(), user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete method.
     *
     * @param user - user.
     * @return boolean - true if deleted.
     * @throws RuntimeException - re.
     */
    public synchronized boolean delete(User user) throws RuntimeException {
        if (usersData.containsKey(user.getId())) {
            if (usersData.containsKey(user.getId())) {
                usersData.remove(user.getId());
                return true;
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("Base does not have this user");
        }

    }

    /**
     * Transfer method.
     * Transfer money from one account to other.
     *
     * @param fromId - id from account.
     * @param toId   - id to account.
     * @param amount - amount of money.
     * @throws RuntimeException - re.
     */
    public synchronized void transfer(int fromId, int toId, int amount) throws RuntimeException {
        User from = usersData.get(fromId);
        User to = usersData.get(toId);
        if (usersData.containsKey(fromId) && usersData.containsKey(toId)) {
            if (from.getAmount() >= amount) {
                from.setAmount(from.getAmount() - amount);
                to.setAmount(to.getAmount() + amount);
            } else {
                throw new RuntimeException("Don't have amount on UserFrom ID");
            }
        } else {
            throw new RuntimeException("Can't find User by ID");
        }
    }

    /**
     * Get user method.
     *
     * @param id - id.
     * @return user.
     */
    synchronized User getUser(int id) {
        return this.usersData.get(id);
    }
}

package ru.job4j.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BankTransfer class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class BankTransfer {
    /**
     * Map user accounts. <User,List<Account>>.
     */
    private Map<User, List<Account>> userAccounts = new HashMap<>();

    /**
     * addUser method.
     *
     * @param user - user.
     */
    public void addUser(User user) {
        this.userAccounts.put(user, new ArrayList<Account>());
    }

    /**
     * delete user method.
     *
     * @param user - user.
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    /**
     * addAccountToUser method.
     *
     * @param passport - String.
     * @param account  - account.
     */
    public void addAccountToUser(String passport, Account account) {
        this.userAccounts.get(findUserByPassport(passport)).add(account);
    }

    /**
     * deleteAccountFromUser method.
     *
     * @param passport - passport.
     * @param account  - account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.userAccounts.get(findUserByPassport(passport)).remove(account);
    }

    /**
     * Get account from user. User is searching by passport.
     *
     * @param passport - String.
     * @return List account.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userAccounts.get(findUserByPassport(passport));
    }

    /**
     * Transfer money method. Transfer money and return true if operation is successfull. Or false if not.
     *
     * @param srcPassport  - passport User from.
     * @param srcRequisite - requsite User from.
     * @param destPassport - passport User to.
     * @param dstRequisite - requsite User from
     * @param amount       - amount of money.
     * @return boolean true or false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                 double amount) {
        User userFrom = findUserByPassport(srcPassport);
        User userTo = findUserByPassport(destPassport);
        Account accountFrom = findAccountByUser(userFrom, srcRequisite);
        Account accountTo = findAccountByUser(userTo, dstRequisite);
        if (accountFrom.getValue() >= amount && userFrom != null
                && userTo != null && accountFrom != null && accountTo != null) {
            accountFrom.setValue((accountFrom.getValue() - amount));
            accountTo.setValue((accountTo.getValue() + amount));
            return true;
        } else {
            return false;
        }
    }

    /**
     * findAccountByUser method.
     *
     * @param user      - user which we search.
     * @param requisite - string.
     * @return account.
     */
    private Account findAccountByUser(User user, String requisite) {
        Account toReturn = null;
        for (Account ac : this.userAccounts.get(user)) {
            if (ac.getRequisites().equals(requisite)) {
                toReturn = ac;
            }
        }
        return toReturn;
    }

    /**
     * findByUserPassport method.
     *
     * @param passport - passport
     * @return User.
     */
    public User findUserByPassport(String passport) {
        User us = null;
        for (User user : this.userAccounts.keySet()) {
            if (user.getPassport() != null && user.getPassport().equals(passport)) {
                us = user;
            }
        }
        return us;
    }

    /**
     * Getter.
     *
     * @return map of User List<Account>.
     */
    public Map<User, List<Account>> getUserAccounts() {
        return userAccounts;
    }
}

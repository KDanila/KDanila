package ru.job4j.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTransfer {

    Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        this.userAccounts.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.userAccounts.get(findUserByPassport(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.userAccounts.get(findUserByPassport(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.userAccounts.get(findUserByPassport(passport));
    }

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

    private Account findAccountByUser(User user, String requisite) {
        Account toReturn = null;
        for (Account ac : this.userAccounts.get(user)) {
            if (ac.getRequisites().equals(requisite)) {
                toReturn = ac;
            }
        }
        return toReturn;
    }

    public User findUserByPassport(String passport) {
        User us = null;
        for (User user : this.userAccounts.keySet()) {
            if (user.getPassport() != null && user.getPassport().equals(passport)) {
                us = user;
            }
        }
        return us;
    }

    public Map<User, List<Account>> getUserAccounts() {
        return userAccounts;
    }
}

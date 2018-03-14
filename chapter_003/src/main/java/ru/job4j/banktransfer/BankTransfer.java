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
        //return toReturn.get(toReturn.indexOf(account)); - протестировать.
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                 double amount) {
        User userFrom = findUserByPassport(srcPassport);
        User userTo = findUserByPassport(destPassport);
        Account accountFrom = findAccountByUser(userFrom, srcRequisite);
        Account accountTo = findAccountByUser(userTo, dstRequisite);
        if(accountFrom.getValue()>=amount){
            accountFrom.setValue((accountFrom.getValue()-amount));
            accountTo.setValue((accountTo.getValue()+amount));
            return true;
        } else{
            return false;
        }
    }

    private Account findAccountByUser(User user, String requisite) {
        Account toReturn = null;
        for (Account ac : this.userAccounts.get(user)) {
            if(ac.getRequisites()==Integer.valueOf(requisite)){
                toReturn = ac;
            }
        }
        if (toReturn==null){
            throw new RuntimeException("Can't find account");
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
        if (us == null) {
            throw new RuntimeException("Can't find user with tis passport");
        }
        return us;
    }
}

/*
Реализовать коллекцию Map для банка

Необходимо создать класс User с полями name, passport.

Добавить методы eqauls() hashCode()

Необходимо создать класс Account с полями value (кол-во денег), requisites (реквизиты счёта) - это банковский счёт.

Реализовать коллекцию Map <User, List<Account>>, обозначающую что у каждого пользователя может быть список банковских счетов.

Необходимо реализовать возможность перечислять деньги, как с одного счёта User на другой счёт того же User,
 так и на счёт другого User.

В программе должны быть методы:

public void addUser(User user) {} - добавление пользователя.

public void deleteUser(User user) {} - удаление пользователя.

public void addAccountToUser(String passport, Account account) {} - добавить счёт пользователю.

public void deleteAccountFromUser(String passport, Account account) {} - удалить один счёт пользователя.

public List<Accounts> getUserAccounts (String passport) {} - получить список счетов для пользователя.

public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
 double amount) - метод для перечисления денег с одного счёта на другой счёт:
если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

Посмотрите на методы Map.putIfAbsent и List.indexOf, как их можно применить в этом задании.

 */
package ru.job4j.banktransfer;

import org.junit.Test;


import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTransferTest {

    @Test
    public void testAddUser() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        bankTransfer.addUser(u1);
        User user = bankTransfer.findUserByPassport("000");
        assertThat(user.getName(), is("Alex"));
    }

    @Test
    public void testDeleteUser() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        bankTransfer.addUser(u1);
        bankTransfer.deleteUser(u1);
        Map<User, List<Account>> userAccounts = bankTransfer.getUserAccounts();
        assertThat(userAccounts.size(), is(0));
    }

    @Test
    public void testAddAccountsToUser() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        Account a1 = new Account(200, "aaa");
        bankTransfer.addUser(u1);
        bankTransfer.addAccountToUser("000", a1);
        Map<User, List<Account>> userAccounts = bankTransfer.getUserAccounts();
        Account result = userAccounts.get(u1).get(0);
        assertThat(result, is(a1));
    }

    @Test
    public void testDeleteAccountsToUser() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        Account a1 = new Account(200, "aaa");
        bankTransfer.addUser(u1);
        bankTransfer.addAccountToUser("000", a1);
        bankTransfer.deleteAccountFromUser("000", a1);
        Map<User, List<Account>> userAccounts = bankTransfer.getUserAccounts();
        List<Account> result = userAccounts.get(u1);
        assertThat(result.size(), is(0));
    }

    @Test
    public void testTransferMoneyToUserWithTrueStatemnet() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        User u2 = new User("Boris", "111");
        Account a1 = new Account(200, "aaa");
        Account a2 = new Account(300, "bbb");
        bankTransfer.addUser(u1);
        bankTransfer.addAccountToUser("000", a1);
        bankTransfer.addUser(u2);
        bankTransfer.addAccountToUser("111", a2);
        bankTransfer.transferMoney("000", "aaa", "111", "bbb", 150);

        assertThat(a2.getValue(), is(450.));
        assertThat(a1.getValue(), is(50.));
    }

    @Test
    public void testTransferMoneyToUserWithFalseStatemnet() {
        BankTransfer bankTransfer = new BankTransfer();
        User u1 = new User("Alex", "000");
        User u2 = new User("Boris", "111");
        Account a1 = new Account(200, "aaa");
        Account a2 = new Account(300, "bbb");
        bankTransfer.addUser(u1);
        bankTransfer.addAccountToUser("000", a1);
        bankTransfer.addUser(u2);
        bankTransfer.addAccountToUser("111", a2);
        boolean result = bankTransfer.transferMoney("000", "aaa",
                "111", "bbb", 450);
        assertThat(result, is(false));

    }

}


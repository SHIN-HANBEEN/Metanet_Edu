package kr.or.kosa.m11d07;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int totalAccount;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(String accountNo, String name) {
        accounts.add(new Account(accountNo, name));
        totalAccount++;
    }

    public Account getAccount(String accountNo) {
        for (Account a : accounts) {
            if (a.getAccountNo().equals(accountNo)) {
                return a;
            }
        }
        return null;
    }

    public List<Account> findAccounts(String name) {
        List<Account> accounts1 = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getName().equals(name)) {
                accounts.add(a);
            }
        }
        return accounts1;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int getTotalAccount() {
        return totalAccount;
    }

}

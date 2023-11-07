package kr.or.kosa.m11d07;

import java.util.ArrayList;
import java.util.List;

class Account {
    private String name;
    private String accountNo;
    private long balance;
    private List<Transaction> transactions;

    public Account(String accountNo, String name) {
        this.name = name;
        this.accountNo = accountNo;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void deposit(long amount) {
        balance += amount;
        Transaction transaction = new Transaction(amount, balance);
        transactions.add(transaction);
        System.out.println(amount + "원 입금하셨습니다.");
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
    }

    public void withdraw(long amount) {
        if (balance < amount) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        balance -= amount;
        Transaction transaction = new Transaction(-amount, balance);
        transactions.add(transaction);
        System.out.println(amount + "원 출금하셨습니다.");
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
    }

    public List<Transaction> getTranscations() {
        System.out.println("= 거래 내역 =");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        return transactions;
    }

    @Override
    public String toString() {
        return "계좌번호 : " + accountNo + ", 소유자 명 : " + name + ", 잔액 : " + balance;
    }
}
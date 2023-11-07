package kr.or.kosa.m11d07;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Transaction {
    private long amount;
    private long balance;
    private String transacetionDate;
    private String transactionTime;

    public Transaction(long amount, long balance) {
        this.amount = amount;
        this.balance = balance;
        this.transacetionDate = String.valueOf(LocalDate.now());
        this.transactionTime = String.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "[거래금액:" + amount + ", 잔액:" + balance + "원 /" + transacetionDate + transactionTime+ "]";

    }

    public long getAmount() {
        return amount;
    }

    public long getBalance() {
        return balance;
    }
}


package kr.or.kosa.m11d07;

import java.util.List;

public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account accout1 = new Account("10071", "백");
        Account accout2 = new Account("890113", "택");
        Account accout3 = new Account("0113", "택");
        Account accout4 = new Account("987654321", "두팔");

        bank.addAccount(accout1.getAccountNo(), accout1.getName());
        bank.addAccount(accout2.getAccountNo(), accout2.getName());
        bank.addAccount(accout3.getAccountNo(), accout3.getName());
        bank.addAccount(accout4.getAccountNo(), accout4.getName());

        List<Account> accounts = bank.getAccounts();
        System.out.println("= 전체 계좌 목록 =");
        for (Account account : accounts) {
            System.out.println(account); //toString 재정의 되어 있다고 가정
        }

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println(bank.getAccount("890113")); //계좌정보출력
        accounts.get(1).deposit(20_000l);

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println(bank.getAccount("890113")); //계좌정보출력
        accounts.get(1).deposit(20_000l);

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println(bank.getAccount("890113")); //계좌정보출력

        System.out.println("= 해당 소유자명의 계좌정보 =");
        for (Account a : accounts) {
            if (a.getName() == accounts.get(1).getName()) {
                System.out.println(a); //toString 재정의 되어 있다고 가정
            }
        }

        accounts.get(1).withdraw(5_500l); //withdraw 함수에서 sysout 되어 있겠죠?

        System.out.println("= 해당 계좌번호의 계좌정보 =");
        System.out.println(bank.getAccount("890113")); //계좌정보출력

        List<Transaction> transactions = accounts.get(1).getTranscations();
        for(Transaction transaction : transactions) {
            System.out.println(transaction); //toString 재정의 되어 있다고 가정
        }
    }
}

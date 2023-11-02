package kr.or.kosa;

import java.util.Scanner;

public class Ex05_Operation {
    public static void main(String[] args) {
        String[] arr = {"예금", "출금", "잔고", "종료"};
        Scanner sc = new Scanner(System.in);
        String value = ""; //사용자 메뉴 선택
        int balance = 10_000; //계좌 잔액
        int money = 0; //입금, 출금 금액
        boolean menucorrect = false; //적절한 메뉴 입력 여부

        do {
            System.out.println("원하시는 메뉴(ex:\"예금\")를 입력하세요.");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i+1 + ". " + arr[i]); //메뉴 출력
            }
            value = sc.nextLine(); //사용자 메뉴 입력

            for (int i = 0; i < arr.length; i++) {
                if (value.equals(arr[i])) {
                    menucorrect = true;
                }
            }
            if (!menucorrect) {
                System.out.println("메뉴를 잘못 입력하셨습니다. 1~4 정수를 입력해주세요.");
            }

            switch (value) {
                case "예금":
                    System.out.println("입금하실 금액을 입력하세요.");
                    money = sc.nextInt();
                    balance += money;
                    System.out.println("입금이 완료되었습니다. 계좌의 잔액은 " + balance + "원 입니다.");
                    break;
                case "출금":
                    System.out.println("출금하실 금액을 입력하세요.");
                    money = sc.nextInt();
                    if (balance < money) {
                        System.out.println("잔액이 부족합니다. 메인 메뉴로 돌아갑니다.");
                        break;
                    }
                    balance -= money;
                    System.out.println("출금이 완료되었습니다. 계좌의 잔액은 " + balance + "원 입니다.");
                    break;
                case "잔고":
                    System.out.println("잔고를 확인합니다.");
                    System.out.println("잔고 : " + balance + "원 입니다.");
                    break;
            }
        } while (value != "종료");
        System.out.println("은행 프로그램이 종료되었습니다. 이용해주셔서 감사합니다.");
    }
}

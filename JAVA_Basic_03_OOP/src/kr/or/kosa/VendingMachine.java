package kr.or.kosa;

import java.util.Scanner;

public class VendingMachine {
    private boolean power;
    private int serialnum;
    private String location;
    private int balance;
    private static int sellcount;

    VendingMachine(int serialnum, String location) {
        this.serialnum = serialnum;
        this.location = location;
        this.balance = 10_000;
        this.power = false;
    }

    void sell(int money) {
        if(!power) { //전원이 꺼진 상태라면 이용 불가
            System.out.println("========== 전원이 꺼진 상태입니다. 고객센터에 문의하세요. ==========");
            return;
        }
        int val = money / 1_000; //val 은 1_000 원 단위로 나눈 몫
        System.out.println("=========== 로또 자판기를 방문해주셔서 감사합니다. ==========");
        if (val == 1) { //만약에 사용자가 입력한 금액이 딱 1000이면
            System.out.println("=========== 1,000 원을 입력하셨습니다 ============");
            System.out.println("6개 로또 번호가 자동으로 출력됩니다.");
            for (int i = 0; i < 6; i++) {
                System.out.println((i+1) + "번째 로또 번호는 " + (int)( Math.random() * 45 + 1) );
                sellcount++; //판매 횟수 더하기
            }
            this.balance += money; //잔액 증가
        } else if(val < 1) {
            System.out.println("=========== " + money + "원을 입력하셨습니다. 부족한 금액을 입력하셨습니다. ============");
            System.out.println("입금하신 " + money + "를 반환합니다.");
        } else if(val > 6) {
            System.out.println("=========== " + money + "원을 입력하셨습니다. 너무 큰 금액을 입력하셨습니다. 1000원 ~ 7000원 사이의 값을 넣어주세요. ============");
            System.out.println("입금하신 " + money + "를 반환합니다.");
        }else {
            System.out.println("=========== " + money + "원을 입력하셨습니다. 총 " + (val-1) + "번 로또 번호를 입력해주세요. ============");
            Scanner sc = new Scanner(System.in);
            for (int j = 0; j < val-1; j++) {
                    System.out.println("=========== 로또 번호를 입력하세요 ===========");
                    int lottonum = sc.nextInt();
                    System.out.println(lottonum + "번을 선택하셨습니다.");
                }
                for (int i = val + 1; i < 6; i++) {
                    System.out.println((val) + "번째 로또 번호는 " + (int)( Math.random() * 45 + 1) );
                }
            }
            sellcount++; //판매 횟수 더하기
            this.balance += money; //잔액 증가
    }

    public void turnOnOff(boolean power) {
        this.power = power;
        System.out.println(serialnum + "번 기계의 전원을 " + ((power) ? "'켜짐'" : "'꺼짐'") + "상태로 변경합니다.");
    }

    static void printCount() {
        System.out.println("현재 전국에 있는 로또 자판기에서 판매된 횟수는 " + sellcount + "번 입니다.");
    }


    void printInfo() {
        System.out.println(location + "에 위치한 " + serialnum + "의 전원은 " + ((power) ? "'켜짐'" : "'꺼짐'") +
                "상태입니다.");
    }
}

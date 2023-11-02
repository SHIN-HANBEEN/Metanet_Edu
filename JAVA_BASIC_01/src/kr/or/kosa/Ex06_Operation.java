package kr.or.kosa;

import java.util.Scanner;

public class Ex06_Operation {
    public static void main(String[] args) {
        boolean win = false; //사용자 승리 여부
        Scanner sc = new Scanner(System.in); // 스캐너 생성

         while(!win) {
            System.out.println("1~3 사이의 정수를 입력하세요.\n1=가위\n2=바위\n3=보");
            int com = (int)(Math.random() * 3 ) + 1; // 컴퓨터의 가위바위보. 1 ~ 3 정수 생성
            int user = sc.nextInt();
            if (user < 1 || user > 3) {
                System.out.println("잘못 입력하셨습니다. 1~3 사이의 정수를 입력하세요.");
            }

            switch (com - user) {
                case 0:
                    System.out.println("비겼습니다. 게임을 다시 합니다.");
                    break;
                case 1, -2:
                    System.out.println("졌습니다. 게임을 다시 합니다.");
                    break;
                case 2, -1:
                    System.out.println("이겼습니다. 게임을 종료합니다.");
                    win = true;
                    break;
            }

        }
    }
}

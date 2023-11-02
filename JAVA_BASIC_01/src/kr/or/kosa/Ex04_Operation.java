package kr.or.kosa;

import java.util.Scanner;

public class Ex04_Operation {
    // do{ 실행블럭 } while(조건판단) { }
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputdata = 0;

        do {
            System.out.println("숫자 입력 (0-9)");
            inputdata = Integer.parseInt(sc.nextLine());
        } while(inputdata >= 10); //조건 결과가 true do. inputdata 가 10 보다 작을 때 동안 계속 진행.

        System.out.println("");
    }

}

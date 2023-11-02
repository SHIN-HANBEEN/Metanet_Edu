package kr.or.kosa;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.next();
        }
        int val1 = Integer.parseInt(arr[0]);
        String operator = arr[1];
        int val2 = Integer.parseInt(arr[2]);

        switch (operator) {
            case "+" -> System.out.println(val1 + val2);
            case "-" -> System.out.println(val1 - val2);
            case "*" -> System.out.println(val1 * val2);
            case "/" -> System.out.println((double) val1 / val2);
        }

        if (10 == 10.0f) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        //삼항 연산자
        int p = 10;
        int p2 = -10;
        int result = (p == p2) ? p : p2;
    }
}

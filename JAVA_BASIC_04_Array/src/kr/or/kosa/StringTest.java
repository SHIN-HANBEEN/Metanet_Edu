package kr.or.kosa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringTest {
    static boolean checkDigit(String source) {
        return source.length() == 14;
    }
    static boolean checkFirstDigitInSecond(String source) {
        return source.charAt(7) == '1' ||
                source.charAt(7) == '2' ||
                source.charAt(7) == '3' ||
                source.charAt(7) == '4';
    }
    static void printIfMale(String source) {
        switch (source.charAt(7)) {
            case '1', '3' :
                System.out.println("남자입니다.");
                break;
            case '2', '4' :
                System.out.println("여자입니다.");
                break;
        }
    }
    public static void main(String[] args) {
        boolean off = false;
        while (!off) {
            Scanner sc = new Scanner(System.in);
            System.out.println("================");
            System.out.println("안녕하세요. 주민번호를 입력해주세요. ex)123456-1234567");
            System.out.println("================");
            //String pattern = "(\\d{6})-(\\d{7})";
            String pattern = "\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4]\\d{6}";

            String source;
            try {
                source = sc.next(pattern);
            } catch (InputMismatchException e) {
                System.out.println("입력값을 잘못 입력하셨어요. 다시 입력해주세요.");
                continue;
            }
            System.out.println("입력하신 주민번호는 " + source + "입니다.");
            System.out.println("14자리를 잘 입력했나요? : " + checkDigit(source));
            System.out.println("뒷번호 첫 번째 자리값 [1-4] 를 잘 입력했나요? : " + checkFirstDigitInSecond(source));
            System.out.print("성별은? : ");
            printIfMale(source);
            off = true;
        }

    }
}

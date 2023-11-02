package kr.or.kosa;

public class OperatorEx01 {
    public static void main(String[] args) {
        int data = 90;
        switch (data) {
            case 100: System.out.println(100);
            case 90: System.out.println(90);
            case 80: System.out.println(80);
            default: System.out.println(100);
        }

        int month = 3;
        String res = "";
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7: res="31일";
                break;
            case 4:
            case 6: res="30일";
                break;
        }


    }

}

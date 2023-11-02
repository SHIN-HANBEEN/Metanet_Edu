package kr.or.kosa;

public class Ex02_DataType {
    public static void main(String[] args) {
        //int (-21 ~ 21)
        int num = 10000000;

        // literal 은 개발자가 직접 입력한 값, 있는 그대로의 값으로, 상수로도 표현합니다.
        //long num2 = 10000000000; // 개발자가 입력한 값은 기본값이 int 이다.
        //이 리터럴 값을 더 큰 그릇에 담을 것이라는 의미로 l 을 붙여주어야 한다.

        long num3 = 10000000000l;

        long num4 = 100; //이렇게 입력하면, 사실 100은 int 그릇에 담겨져 있다.
        // 자동 형변환이 되기 때문에 문제가 없는 것처럼 보이는 겁니다.
        // 이런 형변환을 암시적 형변환이라고 합니다.

        //int num5 = 10000000000l;
        // 이번에는 자동 형변환을 해주지 않습니다. ( 값의 손실이 있을 수 있기 때문에)
        // 쓰레기 값이 나오거나 값의 손실이 발생하는 것을 알 수 있습니다.
        // 따라서 리터럴 값에 맞게 담는 그릇을 바꾸는 것이 맞는 방법입니다.

        int num6 = (int)1000L; //우연히도 작은 값이기 때문에 문제가 없었던 것이다.

        // java 에는 이스케이프시퀀스 문자가 있다. 특정 문자 앞에 \ 을 붙이면 그 다음 값은 데이터로 인정합니다.

        String name = "홍\"길\"동";
        System.out.println(name);

        //quiz "C:\Temp" 문자열을 출력하고 싶어요. String 변수에 담아서.
        String dir = "C:\\Temp";
        System.out.println(dir);

        //String dir2 = "C:\Temp";

        //byte 는 네트워크 데이터 교환, 파일처리, 이미지 업로드 등에서 사용하는데, Array 로 사용한다.

        double data4 = 100;
        int number = 100;
        double result2 = data4 + number;
    }
}

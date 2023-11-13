package kr.or.kosa.m11d09.selfstudy.javaproblems;
/*
    어떤 정수들이 있습니다.
    이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로
    담은 불리언 배열 signs가 매개변수로 주어집니다.
    실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.

    입출력 예
    absolutes	       signs	  result
    [4,7,12]	[true,false,true]	9
 */
public class M11D06_02 {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution() {
        int[] arr = new int[10];
        boolean[] signs = new boolean[10];
        int[] absolutes = new int[10];
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            int b = (int)(Math.random() * 10 + 1);
            if ( b < 5 ) {
                arr[i] = (-1) * b;
                signs[i] = false;
                absolutes[i] = b;
            } else {
                arr[i] = b;
                signs[i] = true;
                absolutes[i] = b;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if (signs[i]) {
                result += absolutes[i];
                System.out.println("-" + absolutes[i]);
            } else {
                result -= absolutes[i];
                System.out.println("+" + absolutes[i]);
            }
        }
        System.out.println("==========================");
        return result;
    }
}

package kr.or.kosa.m11d09.selfstudy.javaproblems;

import java.util.Arrays;

/*
    문제 설명:
    머쓱이는 추운 날에도 아이스 아메리카노만 마십니다.
    아이스 아메리카노는 한잔에 5,500원입니다.
    머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때,
     머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을
    순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

    제한사항:
    0 < money <= 1000,000

    입출력 예:
    money  result
    5,500   [1,0]
    15,000  [2,4000]

    입출력 예 성명:
    - 5500원은 아이스 아메리카노 한 잔을 살 수 있고 잔돈은 0원입니다.
    - 15000원은 아이스 아메리카노 두 잔을 살 수 있고 전돈은 4000원입니다.
 */
public class M11D07_01 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5500)));
        System.out.println(Arrays.toString(solution(15000)));
    }
    public static int[] solution(int money) {
        int price = 5_500;
        int[] arr = new int[2];
        arr[0] = money / price;
        arr[1] = money % price;
        return arr;
    }

}

package kr.or.kosa.m11d09.selfstudy.javaproblems;

import java.util.Scanner;

/*
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
n은 2 이상 100,000 이하인 자연수입니다.
입출력 예
n	return
3	2
5	5
입출력 예 설명
피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 */
public class M11D06_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("2 이상 100,000 이하인 정수 n을 입력하세요 : ");
        int n = sc.nextInt();
        System.out.println(fibonacci.DFS(n));
    }
}

class Fibonacci {
    int DFS(int n) {
        if(n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return DFS(n-2) + DFS(n-1);
        }
    }
}


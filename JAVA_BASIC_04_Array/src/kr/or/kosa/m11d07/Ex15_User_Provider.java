package kr.or.kosa.m11d07;

import java.util.HashSet;
import java.util.Set;

/*
    Set 인터페이스
        순서를 보장 x, 중복을 허락하지 않아요.
        순서가 없고 중복을 허락하지 않는 데이터 집합

    구현하는 클래스는 HashSet, TreeSet
 */
public class Ex15_User_Provider {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        System.out.println(hs.add(10));
        System.out.println(hs.toString());
        /*
            이런 것을 주로 로또 번호와 같은 곳에 쓰는 자료구조입니다.
            차량번호, 회원아이디 등에 사용할 수 있겠습니다.
         */

        Set set2 = new HashSet();
        while(set2.size() < 6) {
            int num = (int)(Math.random() * 45 + 1);
            set2.add(num);
        }
        System.out.println(set2.toString());
    }
}

package kr.or.kosa.m11d07;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    Collection Framework
    [ 다수의 데이터 ]를 다루는 [ 표준화된 인터페이스 ]를 구현하고 있는 [ 클래스 집합 ]이다.

    ArrayList 의 부모타입은 List!
    instanceof 로 확인할 수 있다.

    1. List (줄을 서시오!, 즉, 홍길동 사람이 여러명이어도 상관없다. 순서가 있기 때문이다.)
        순서(O), 중복(O)

    1.1 Vector (구버전)
        동기화 보장(O)
        멀티 스레드 환경 (Lock)
        성능 x, 보안 o

    1.2 ArrayList (신버전)
        동기화 보장(X)
        성능 o, 보안 x

    ==========================
    ArrayList ...
    1. 배열의 크기가 동적으로 확장 or 축소 가능 >> 하지만, 내부적으로는 컴파일러가 정적 배열을
        만들어서 옮기는 중!

 */
public class Ex01_ArrayList {
    public static void main(String[] args) {
        //사원 2명을 ArrayList 로 만들어라.
        List list = new ArrayList();
        list.add(new Emp(100, "김신", "개발자"));
        list.add(new Emp(101, "유신", "개발자"));
        /*
            List 는 capacity 를 가지고 있고,
            그래서 length 가 아니고 size( ) 를 갖고 있습니다.
            size() 의 장점은 실제 차있는 개수를 가져오기 때문에,
            비어있는 곳은 for 문에서 돌지 않습니다.
         */
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i); //이렇게 get( ) 을 하면 return type 이 Object 로 떨어진다. 제네릭을 사용하지 않았기 때문이다.
            Emp emp = (Emp)obj;
            emp.getEmpno();
            emp.getEname();
        }

        //Generic (제네릭) : 타입 강제해주는 목적
        List<Emp> list1 = new ArrayList<>();
        list1.add(new Emp(1,"r", "3"));
        for (Emp e : list1) {
            e.getEname();
        }
    }
}

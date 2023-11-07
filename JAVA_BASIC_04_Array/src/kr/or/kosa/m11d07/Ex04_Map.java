package kr.or.kosa.m11d07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
    Map 인터페이스는 Key, value 쌍의 구조입니다.
    Key 는 Set 계열이기 때문에 중복을 허용하지 않습니다.

    구버전 : HashTable (동기화 보장)
    신버전 : HashMap (동기화 보장 X)
 */

class Student {
    int kor;
    int math;
    int eng;
    String name;
    public Student(int kor, int math, int eng, String name) {
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.name = name;
    }
}
public class Ex04_Map {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Tiger", "1004");
        map.put("scott", "1004");

        System.out.println(map.containsKey("tiger"));
        System.out.println(map.get("Tiger"));
        Set set = map.keySet();
        /*
            key 의 집합은 중복값이 없고 순서를 보장하지 않는 구나~
         */

        /*
            Iterator 는 표준화된 출력을 해주는 객체입니다.
            for 문을 사용해도 상관 없으나,어떤 개발자가 퇴사를 하고 이직을 해도
            서로 알아보고 유지보수 하게 돕기 위해서이다.
         */
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //HashMap<String, String> map1 = new HashMap<>();
//        HashMap<Integer, String> map1
//        HashMap<String, Student>
//        HashMap><String, List<Student>>

        HashMap<String, Student> smap = new HashMap<>();
        smap.put("hong", new Student(100, 80, 50, "홍길동"));
        smap.put("kim", new Student(100, 80, 50, "김길동"));
        System.out.println(smap.get("hong"));


    }
}

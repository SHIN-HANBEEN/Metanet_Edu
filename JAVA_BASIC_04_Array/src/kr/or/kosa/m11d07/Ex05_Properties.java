package kr.or.kosa.m11d07;

import java.util.Properties;

/*
    Map 인터페이스를 구현한 클래스인 Properties

    사용목적
        1. App 전체에 사용되는 자원관리
        2. 환경변수 (전역의 의미)
        3. 프로그램의 버전
        4. 로그인ID, 비번
        5. 공통변수
 */
public class Ex05_Properties {
    public static void main(String[] args) {
        Properties prop = new Properties(); //내부적으로 String, String 이기 때문에 타입 지정 필요 x
        prop.setProperty("admin", "kosa@kosa.or.kr");
        prop.setProperty("downpath", "C:\\Temp\\image");

        /*
            10개의 페이지에서 공통으로 admin 을 같은 값을 가지게 해줄 수 있다.
            그런 목적을 가진 것이 Properties 입니다.
         */
        System.out.println(prop.getProperty("admin"));
    }
}

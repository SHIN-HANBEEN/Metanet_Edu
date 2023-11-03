package kr.or.kosa;

/*
    OOP 객체 지향 프로그래밍 : 여러 개의 작은 조각(작은 설계도)를 만들어서 조합(큰 설계도) 하는 행위입니다.
    객체지향의 궁극적인 목표는 '재사용'입니다.
    '재사용'을 위해서 상속, 다형성 등을 사용합니다.

    1. 상속 (재사용성)
    2. 캡슐화 (은닉화)
    3. 다형성 : 하나의 타입으로 여러개 객체의 주소를 가질 수 있는 것

    다형성에 대해서 더 살펴보자
    - method overloading
        같은 이름으로 여러가지 기능을 하는 함수.
        대표적인 예시로는 println( ) 이겠다.
        다양한 매개변수를 println( )이 받을 수 있는 이유는 다형성을 통해서 구현되었기 때문이다.
        결국 오버로딩은 '매개변수'의 '개수'와 '타입'을 구분하는 것이다.
        오버로딩은 성능과 일절 상관이 없고, 개발자를 배려하기 위한 장치이다.
        헷갈리는 점들이 몇 가지 있다.
        return type 은 오버로딩 판단 기준이 아닙니다.
        매개변수의 순서도 오버로딩 판단 기준입니다. (int i, String j) != (String j, int i)

 */

class Human {

}
class OverT {
    int add(int i) {
        return 100 + i;
    }
    //void add(int i2) {
    //    return 200 + i2;
    //}

    /*
        위에서 보는 것과 같이 return type 은 오버로딩의 판단 기준이 될 수 없습니다. 오직 이름과 매개변수로 판단합니다.
     */

    void add(String s, int i) {}
    void add(int i, String s) {}
    /*
        매개변수의 순서가 다름을 인정하는 오버로딩을 볼 수 있습니다.
     */

    void add(Human human) {}
}
public class Ex08_Method_Overloading {

}

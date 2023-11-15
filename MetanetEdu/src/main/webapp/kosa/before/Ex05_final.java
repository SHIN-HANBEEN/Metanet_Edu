package kr.or.kosa.before;
/*
변수 <>  상수
상수 : 한번 값이 [초기화] 되면 변경 불가
상수자원 : 고유값 >> 주민번호 , 수학 : PI=3.141591... , 시스템번호 (버전번호 v1.0 , v1.0.0)
상수 관용적으로 대문자

JAVA : final int NUM=10;
C#   : const integer NUM=10;

final 키워드
1. final class Car {} >> 상속금지
ex) public final class Math extends Object

2. public final void print(){} >> 상속관계에서 재정의 금지 //차라리 private 을 자주 쓴다.

3. member field (상수) 중요
*/

class Vcard {
    /*
        static 이 붙은 상수는 모든 객체가 동일한 상수를 바라본다는 의미이다.
        따라서, 생성자에서 초기화하지 않는다.

        반대로 인스턴스 상수는 인스턴스마다 다른 값을 갖겠다는 의도가 담겨있는 것이다.
     */
    final static int Number = 100;
    final String KIND="heart";
    final int NUM=10;

    void method() {
        System.out.println(Math.PI);
    }
}

/*
    설계자 입장에서 초기화하지 않은 변수를 선언하는 것은 무엇일까?
    바로, 생성자를 통해서 초기화하겠다는 것이다.
    예를 들어서, 53장의 카드가 모두 다른 카드 번호라는 상수를 갖길 원한다.
 */
class Vcard2 {
    final String KIND;
    final int NUM;

    Vcard2(String KIND, int NUM) {
        this.KIND = KIND;
        this.NUM = NUM;
    }


    void method() {
        System.out.println(Math.PI);
    }
}

public class Ex05_final {
    public static void main(String[] args) {
        Vcard vcard = new Vcard();

        Vcard2 vcard2 = new Vcard2("spade", 10);
    }
}

package kr.or.kosa.before;
/*
    다형성 : 여러 가지 성질(상태)를 가질 수 있는 능력
    다형성 : 상속 관계에서 존재합니다.
    JAVA : 상속관계에서 하나의 참조변수가 여러개의 타입을 가질 수 있는 것을 의미합니다.
    [하나의 참조변수] >> 부모타입

    부모 타입 참조변수는 자식 클래스가 재정의한 메서드에 접근할 수 있다.(재정의는 매우 강력하다)
 */
class Tv2 {
    boolean power;

}

class CapTv extends Tv2 {

}
public class Ex08_Inheritance_Poly {
    /*
        상속관계에서 부모타입의 참조변수는 여러 개의 자식타입의 참조주소를 가질 수 있습니다.
        단 부모는 [자신의 자원만 접근] 가능
        단 재정의(인스턴스메서드)는 제외하고!
     */

}

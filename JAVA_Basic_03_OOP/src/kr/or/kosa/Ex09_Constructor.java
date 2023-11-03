package kr.or.kosa;
/*
    생성자 함수(constructor)
    1. 특수한 목적 함수입니다.
    2. 목적 : member fiel 초기화입니다.

    일반 함수와 다른 점
    1. 함수 이름이 고정 (class 이름 사용)
    2. return type 이 없음 (객체 생성과 동시 호출이기 때문에, 받아줄 객체가 없다)
    3. 실행시점 : new 객체 생성 - heap 객체 생성 - member field 자리 - 자동으로 생성자 함수 호출

    왜 사용할까
        [생성되는 객체]마다 [강제적]으로 member field 를 초기화 하고 싶기 때문이다.

    class Car { String color; }
        설계도를 만든이는 색상을 너가 알아서 하라는 의도로 만든 것이다.

    문제는 이런 거죠. 자동차가 색상이 없으면 출고되지 않도록 하고 싶은 것이다.
    바로 이럴 때 오버로드를 사용하여 생성자 함수를 사용하게 됩니다.
    멤버 필드를 강제적으로 초기화할 수 있게 됩니다.
 */

class Car {
    String carname = "포니";
    /*
        생성자를 구현하지 않으면 컴파일러가 default 생성자를 만든다.
        왜냐하면 생성자가 없으면 객체를 쓸 수가 없다.
     */
}
class Car2 {
    String carname;
    Car2() {}
    Car2(String carname) {
        this.carname = carname;
    }
}
class Car3 {
    String carname;
    Car3(String carname) { //오버로딩 된 생성자가 하나라도 있다면, default 생성자는 자동생성되지 않습니다.
        this.carname = carname;
    }
    /*
        즉, Overloading 된 생성자가 있다는 의미는, 초기화에 강제성을 주었다는 것을 의미합니다.
     */
}

/*
    제품을 판매할 때 여러 옵션에 대한 선택권과 강제성을 생성자를 통해 줄 수 있다.

    시나리오를 예로 들어보면 다음과 같다.
    자동차 영업소입니다.
    영업사원은 고객에게 자동차를 팔려고 합니다.
    고객은 자동차의 기본 사양을 살 수도 있고, 여러 가지 선택 옵션을 선택할 수 있습니다.
    자동차의 기본은 문 4개, 색상 red 입니다.
 */
class Car7 {
    String carcolor;
    int door;
    public Car7() {
        carcolor = "blue";
        door = 4;
    }
}
public class Ex09_Constructor {
    public static void main(String[] args) {

    }
}

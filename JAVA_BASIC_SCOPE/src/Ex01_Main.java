// 클래스 == 설계도 == 데이터 타입(사용자가 정의한다)
// 설계도라고 판단할 수 있는 근거는 최소한 속성과 기능이 필요하다.
// 프로그램 용어로 부르면 필드와 메서드가 필요합니다. + 생성자(함수)가 필요합니다.
// 필드(member field)는 데이터, 자료(정보)를 담고 있는 것입니다.
// 정보에는 고유 정보, 상태 정보가 있습니다. 그 다음 부품 정보가 있습니다.
// 고유정보에는 자동차 설계도라고 한다면, 제조회사 같은 것들이 들어갈 수 있겠습니다.
// 상태정보는 이랬다 저랬다 하는 것들로, 자동차 클래스에는 속도 같은 것들이 들어갈 수 있겠습니다. 수시로 값이 변하죠.
// 부품정보라는 것은 다른 클래스입니다. 자동차 클래스에는 엔진 클래스가 있겠습니다.
/*
    class 설계도 이름 {
        고유정보 : 제조회사 = 현대, 이름, 주민번호
        상태정보 : 자동차 설계도 > 속도
        부품정보 : 자동사 설계도 > 다른 클래스 > 엔진 클래스
        +
        기능(행위)
        +
        생성자(메서드) : 초기화 목적(만들어진 인스턴스마다 초기화)
    }

    class engine {

    }

    class Car {
        comname
    }

 */

import java.util.Objects;

class Emp2 {

}

class Dept {
    int deptno;
    public String dname; // class 가 default 인데 public 멤버를 갖는 것은 의미가 아예없다.
    private int count; // private 을 하면 캡슐화, 은닉이 된 것입니다. private 은 클래스 내부에서만 사용하겠다는 의미입니다.
    // private 을 하면, 직접 할당을 막고 간접 할당을 하겠다는 의미입니다.
    // 자바에서는 Getter(읽기 전용), Setter(쓰기 전용) 로 간접 할당을 지원합니다.
    // 이런 이유 때문에 실무에서는 모두 private 을 사용하게 됩니다.
    int getCount() {
        return this.count;
    }
    void setCount(int count) {
        this.count = count;
    }
}

public class Ex01_Main {
    public static void main(String[] args) {

    }
}

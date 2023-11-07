package kr.or.kosa;

/*
    인터페이스는 개발을 할 때 약속, 규칙, 규약, 표준을 만드는 것입니다.
    초급 개발자가 인터페이스를 개발하는 것은 정말 어렵습니다.
    그래서 우리의 목표는 인터페이스를 잘 사용하는 것입니다.

    그런데, 인터페이스의 약속, 규칙, 규약, 표준을 따르면 뭐가 좋은 것일까요?

    A라는 회사가 회계팀을 모집한다고 생각해보겠습니다.
    홍길동이라는 친구가 회사에 입사하게 되었다고 해봅시다.
    그런데, B라는 회사로 홍길동이 이직했다고 해봅시다.
    홍길동한테 회계장부를 가져오라고 팀장님이 시켰는데, 못 찾아옵니다.
    알고보니 이전회사와 지금회사의 표준화가 되지 않아서 회사마다 달라서 다시 배워야 하는 상황이 되는 것이죠.

    ISO88 ~ 이런 것이 회사들이 지켜야하는 규약입니다.
    ISO 표준은 왜 쓸까요?
    왜 문서를 작성할 때 표준화되어 있기 때문에, 어떤 회사를 가도 동일한 형태로
    작성되어 있을 것이라고 알 수 있습니다.

    개발할 때 인터페이스가 바로 이것입니다.
    자동차를 멈출 때는 stop( ) 을 부를거야! 달릴 때는 run( ) 을 부를거야!
    라는 규칙을 세워두면, 구현부는 알 필요도 없으며, 그냥 stop( ) 과 run( )
    만 쓰면 된다고 인터페이스만 보고 이해할 수 있습니다.

    그래서 인터페이스가 어렵습니다. 이런 규칙들을 만들어야 하니까요.

    그래도 다행인 것은 자바는 수많은 인터페이스를 만들어 두었기 우리는 만들어진 것을
    사용하기만 하면 됩니다.

    대표적인 인터페이스가 컬렉션 입니다.
    예를 들어 List 인터페이스를 구현한 클래스를 사용할 때는 구현체를 볼 필요가 없습니다.
    그냥 List 인터페이스를 보면 어떻게 사용하는지 다 알 수 있습니다.

    =============================
    추상 클래스와 인터페이스 공통점
    1. 스스로 객체 생성 불가능 (new 연산자 불가능)
    2. 둘 다 강제성을 목표로 사용합니다.

    추상 클래스와 인터페이스 다른점
    1. 추상 클래스는 완성 + 미완성 / 인터페이스는 모든 것이 미완성
    2. 원칙적으로 클래스는 다중상속 불가능 >> 계층적 상속 또는 포함 관계를 이용한다
        그런데, 인터페이스는 [다중 상속]이 가능 >> 여러 개의 작은 인터페이스를 모을 수 있다
        너무 큰 인터페이스를 만들면 재사용성이 떨어진다

    interface 는 implements, 추상 클래스는 extends 를 사용하는 이유입니다.

    ==============================
    초급 개발자의 시선으로 봅시다.
    1. 인터페이스를 [ 다형성 ] 입장으로 접근합시다. (인터페이스 모든 타입 부모)
    2. 서로 연관성이 없는 클래스를 하나로 묶어주는 역할 (같은 부모를 가지게 함으로써)
    3. JAVA API 수 많은 인터페이스를 생성해 놓았다
    4. 인터페이스는 ~able 로 이름을 적는다.
    5. 객체간 연결 고리 (객체간 소통) 다형성

    ==========================
    인터페이스는 다중 상속이 가능하다.
    왜 그렇냐면, 약속의 단위가 너무 커져버리면 구현하는 클래스들이 모두 구현해야하기 때문에 힘들다.
    그래서, 작은 약속들을 모아서 하는 것이 더 좋다고 생각할 수 있다.

    인터페이스는 상수와 default 함수를 가지고 있긴 하지만, 이것은 예외적인 것이고, 기본적으로
    미완성의 설계도 입니다.

    ==========================
    인터페이스는 ...
    1. 상수 구현 가능
    public static final int VERSION=1 >> int VERSION 으로 써도 된다.
    (어차피 인터페이스에서 상수를 선언하면 아무곳에서나 쓸 수 있어야 하기 때문
     컴파일러가 알아서 추가해준다)
    2. 추상함수
    public abstract void run(); >> void run()
    (인터페이스에 있는 함수는 추상 함수니까, 생략 가능하게 해두었다)

    ======================
    인터페이스의 종류
    1. interface Aable {} //아무 자원이 없음 == 같은 가족으로 묶기 위한 용도
    2.



 */

interface Ia {
    int AGE = 100; //public static final 생략
    String GENDER = "MALE"; //public static final 생략
    //String print() {}; //실행 블럭을 가질 수 없습니다.
    String print(); //public abstract 생략
}

class Test2 implements Ia {

    @Override
    public String print() {
        return null;
    }

}

public class Ex14_Interface {

}

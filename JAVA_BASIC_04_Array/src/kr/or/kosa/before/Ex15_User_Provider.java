package kr.or.kosa.before;
/*
    DB에서 EMP테이블 안에 deptno(fk), Dept 테이블 안에 deptno(pk), dname, loc
    사원 테이블에 있는 부서 번호는 부서 테이블의 부서 번호를 참조합니다.
    사원 테이블은 foreign key 제약, 부서 테이블은 primary 제약을 갖는 겁니다.

    master detail 을 출력하라는 말을 들으면,
    부서 테이블을 우선 보내고, 부서 번호를 클릭하면 그에 해당하는 테이블이 출력되면 된다.

    user 와 provider
    user 는 자원을 사용하는 사용자 입니다.
    provicder 는 자원을 제공하는 제공자 입니다.

    우리가 소위 말하는 설계도를 만드는 것을 배우고 있는데요.
    각각의 설계도는 독자적으로 존재하는 경우는 거의 없습니다.

    class A {}
    class B {}

    관계 : A는 B를 사용합니다.
    -> 굉장히 모호한 말이죠. 관계는 상속 & 포함 밖에 없습니다.
    1. 상속 : A extends B
    2. 포함 : A { B b = new B(); } >> A 라는 클래스가 B 를 member field 로 즉, 부품으로
            사용하는 것을 의미합니다.

    주로 상속 보다는 포함을 더 많이 사용합니다.

    ====================
    포함 : 부분 vs 전체 로 나뉘어져있습니다
    1. 부분 (생명주기 동일하지 않음)
    class B {}
    class A {
        int i;
        B b;
        A() {

        }

        // method
        void method(B b) {
            this.b = b;
        }
    }

    이렇게 하면, 가장 큰 차이는 A 에는 B 에 대한 new 생성자가 없습니다.
    main() {
        A a = new A();
        B b = new B();

        // A와 B는 따로 만들어지고,
            필요에 따라서 B 를 A에 포함시킬 수 있습니다.

        a.method(b);

        // 노트북하고 마우스의 관계라고 할 수 있겠습니다.
        // 학교하고 학생의 관계도 가능하겠네요.
    }


    2. 전체 (생명주기 동일함)

    class B {}
    class A {
        int i;

        //A는 B를 사용합니다.
        B b;
        A() {
         b = new B();
        }
    }

    >> main() {
        A a = new A();
    }

    위와 같은 형태가 전체 집합입니다. == 운명 공동체인 것이죠.
    또한, B 는 독자 생성이 불가능합니다.
    운명 공동체의 개념으로 봅니다.
    대표적인 예제는 자동차와 엔진이라고 할 수 있습니다.
    자동차가 생성되면 엔진이 무조건 생성되어야 합니다.
    노트북과 CPU 도 마찬가지겠네요.

    ==============================
    A는 B를 사용합니다.(참조) >> 포함 >> A가 B를 member field
    >> 생성(전체, 부분 으로 나뉘어진다.)

    그리고 의존 Dependency 는 '함수 안에서 create, local, parameter'!! 라는 걸 생각합시다.

 */
public class Ex15_User_Provider {

}
































































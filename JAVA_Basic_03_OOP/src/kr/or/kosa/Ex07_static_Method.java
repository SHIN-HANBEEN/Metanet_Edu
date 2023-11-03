package kr.or.kosa;

/*
    static member field : 객체간 공유자원 목적!
    static method :
        1. 객체 생성 없이 사용하려고 (x)
        2. 편하게,, 빠르게.. (x)
        3. 정답은 많이 사용하니까 입니다. new 를 계속 하기 너무 힘드니까.
            static 을 붙이면 편하게 사용할 수 있게 해주는 것이다.
            이것은 사용자에 대한 배려라고 할 수 있는데,
            static 은 메모리를 많이 잡아먹기 때문이다.
            메모리의 사용을 감수하고 사용자의 편의성을 확보하는 것이라고 할 수 있겠다.
        4. 설계도 : 이 기능은 많이 사용할 것 같아..
            자원을 많이 사용한다 -> 편하게 쓰고 싶다 -> new -> static 설계
 */

class StaticClass {
    int iv;
    static int cv;
    static void print() {
        //System.out.println(iv);
        /*
            static 함수는 static 변수만 사용할 수 있는데,
            static 이 생성되는 시점에는 instance 는 생성되지 않은 시점이기 때문이다.
            일반 자원에 static 메서드는 접근할 수 없다.
         */
    }
    void printIv() {
        /*
            일반함수는 일반자원과 static 자원을 모두 사용할 수 있습니다.
         */
        System.out.println(iv);
        cv = 100;
    }
}
public class Ex07_static_Method {
    public static void main(String[] args) {

    }
}

package kr.or.kosa.before;
/*
    디자인 패턴 중 생성에 관련된 것을 좀 볼까요?
    new 에 관련한 이야기입니다.

    싱글톤은 객체 하나를 만들어서 공유하겠다는 의미입니다.
    static "객체 간 공유 자원" 이 떠오르시죠?

    의도는 뭘까?
    하나의 객체를 공유하는 보장성 코드를 만드려는 것입니다.

    우리가 클래스를 만들면 new 를 할 수 있는데요.
    new 를 못하게 하려면, 생성자에 접근하지 못하게 해야겠네요.
    그러면! 생성자를 private 으로 만들면 되겠네요!
 */
public class Singleton {
    /*
        Singleton s = new Singleton( );
        Singleton s2 = new Singleton( );

        private 은 클래스 내부에서는 public 과 다를바 없죠!
     */
    //private static Singleton p = new Singleton();
    /*
        위와 같이 처리하면, 정말 단 하나의 인스턴스만 사용하는 것이라고 할 수가 없다.
        예를 들어,
        Singleton singleton1 = Singleton.p;
        Singleton singleton2 = Singleton.p;
        Singleton singleton3 = Singleton.p;
        이렇게 하면 안전성을 확보해줄 수 없다. (솔직히 정확히 어떻게 분리하는지 이해하기 어렵다)
     */
    private static Singleton p;

    private Singleton() {}
    public static Singleton getInstance() {
        if(p == null) {
            p = new Singleton(); //생성자 함수 호출 ( 클래스 내부에서 private 과 public 차이는 없다)
        }
        return p;
    }
}

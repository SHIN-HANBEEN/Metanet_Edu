package kr.or.kosa.before;

class Bi extends Bird {
    @Override
    protected void moveFast() {
        super.moveFast(); //상속 관계에서는 public 하게 바뀌기 때문에 접근 가능해서 사용할 수 있다.
    }
}
class Ostrich extends Bird {
    //특수화, 구체화 : void run( ) 이다.

    @Override
    protected void moveFast() {
        System.out.println("run...");
    }
}
public class Ex07_inherit_Protected {
    public static void main(String[] args) {
        Bi bi = new Bi();
        bi.fly();
        bi.moveFast();
        /*
            moveFast( ) 메소드는 재정의 하지 않으면 사용할 수 없다.
            protected 상태이기 때문이다.

            따라서 상속 받는 자손 클래스에서 재정의 해야만 쓸 수 있다.

            이렇게 만든 이유는 다음과 같습니다.
            위의 Ostrich 와 같이, moveFast( ) 가 날아서 빠른게 아니라, run 때문에 빠르다고 보는 것이다.
         */

        Ostrich ostrich = new Ostrich();
        ostrich.fly();
        ostrich.moveFast();
    }
}

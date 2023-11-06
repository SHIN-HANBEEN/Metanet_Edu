package kr.or.kosa;


class Dclass {
    public int i;
    private int p;
    int s;
    protected int k; //결국 default 와 동일합니다. 상속이 아니면 쓰지 않는 접근자입니다.
}

class Child2 extends Pclass{
    void method() {
        this.k = 100;
        /*
            상속관계에서 자식함수는 부모의 Protected 자원을 사용할 수 있습니다.
            protected 접근제어자는 상속관계에서는 Public 처럼 동작하지만 그 외의 관계에서는
            default 접근 제어자처럼 동작합니다.
         */
    }

    @Override
    protected void m() {
        super.m();
    }
}

public class Ex06_inherit_Protected {
    public static void main(String[] args) {
        Pclass pclass = new Pclass();

    }
}

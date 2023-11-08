package kr.or.kosa.before;

public class Bird {
    public void fly() {
        System.out.println("flying");
    }

    /*
        설계자의 고민
        Bird 를 상속하는 당신은 moveFast() 자원에 대해서 재정의 해서 써야해.. 강제야!

        무슨 고민이냐면, 새가 빠르게 움직이는게, 날라다니는거 말고 달리기가 빠른 새가 있을 수 있잖아!
     */
    protected void moveFast() {
        fly();
    }
}

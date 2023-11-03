package kr.or.kosa;

public class Person {
    public String name;
    public int age;
    public boolean power;
    /*
        기본값을 초기화해주지는 않습니다.
        생성자를 통해서 인스턴스가 생성되기 때문입니다.
        기본값을 쓰지 않는 이유는 생성되는 객체마다 다른 값을 가질 수 있기 때문이다.
     */

    public void personPrint() {
        System.out.printf("이름은 %s 나이는 %d 파워는 %s입니다.\n", name, age, power);
    }
}

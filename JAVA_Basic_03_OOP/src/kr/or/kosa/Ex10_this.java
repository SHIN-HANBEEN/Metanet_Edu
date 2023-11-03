package kr.or.kosa;
/*
    this (이것)
        1. 객체 자신을 가리키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정됩니다)
            즉,
        2. this 를 활용한 생성자
            원칙적으로 생성자는 객체 생성 시 한개가 사용 됩니다.
            그런데 this 를 활용하면 예외적으로 this 를 통해 생성자를 호출할 수 있습니다.
            이를 통해서 생성자들의 오버로딩에서 반복되는 코드를 줄일 수 있습니다.
 */
class Socar {
    String color;
    String gearType;
    int door;

    Socar() {
        this("기본색", "기본기어", 4);
        System.out.println("default");
        /*
            this() 를 활용한 생성자를 사용하면 코드량이 감소하는 아주 행복한 일이 발생한다.
         */
    }
    Socar(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
        System.out.println("overloading");
    }
    void socarPrint() {
        System.out.println(this.color + ", " + this.gearType + " , " + this.door);
    }
}

public class Ex10_this {
    public static void main(String[] args) {

    }
}

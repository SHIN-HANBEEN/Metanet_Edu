package kr.or.kosa;

/*
    게임에 유닛이 있습니다.

    Unit : 공통기능(이동좌표, 이동, 멈춘다) : 추상화, 일반화
    Unit : 이동방법은 다르다 (이동방법은 unit 마다 별도의 구현 필요(반드시))
 */

abstract class Unit {
    int x;
    int y;
    abstract void move(int x, int y);
}

class Marine extends Unit {
    @Override
    void move(int x, int y) {
        System.out.println("걸어서 이동");
        System.out.println(x + "좌표, " + y + "좌표로 이동합니다.");

    }
}

class Dropship extends Unit {

    @Override
    void move(int x, int y) {
        System.out.println("날아서 이동");
        System.out.println(x + "좌표, " + y + "좌표로 이동합니다.");
    }
}

class Scout extends Unit {

    @Override
    void move(int x, int y) {
        System.out.println("날아서 이동합니다.");
        System.out.println(x + "좌표, " + y + "좌표로 이동합니다.");
    }
}

class Tank extends Unit {

    @Override
    void move(int x, int y) {
        System.out.println("궤도로 이동합니다.");
        System.out.println(x + "좌표, " + y + "좌표로 이동합니다.");
    }

    void changeSeizeMode() {
        System.out.println("시즈 모드로 변경합니다.");
    }
}
public class Ex13_Abstract_class {
    public static void main(String[] args) {
        /*
            Java 에서 객체의 타입을 비교하는 연산자 instanceof
            JS 에서 타입을 비교하는 연산자는 typeof 입니다.
            JS 에도 instanceof 가 있는데요. typeof 를 더 많이 사용합니다.
         */

        Tank[] tanks = {new Tank(), new Tank(), new Tank()};
        Unit[] units = {new Tank(), new Marine(), new Dropship()};

        for(Tank t : tanks) {
            t.move(600, 800);
        }
        for(Unit unit : units) {
            unit.move(666, 888);
        }

//        if(tank instanceof Unit) { //tank 객체는 Unit 타입입니까? true
//
//        }

    }
}

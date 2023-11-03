package kr.or.kosa;
/*
public class AirPlane {
    private String name;
    private int num;
    private static int count; //객체간 공유자원이 필요한 순간입니다.
    public void makeAirPlane(String name, int num) {
        this.name = name;
        this.num = num;
        count++;
        printInfo();
    }
    public static void printInfo() {
        System.out.println("현재 생산된 비행기의 수는 " + count + "대 입니다.");
    }
    public static void main(String[] args) {
        AirPlane airPlane1 = new AirPlane();
        airPlane1.makeAirPlane("대한항공", 505);

        AirPlane airPlane2 = new AirPlane();
        airPlane2.makeAirPlane("델타항공", 707);
    }
}
*/

public class AirPlane {
    private String name;
    private int planeNumber;
    private static int count;

    AirPlane(String name, int planeNumber) {
        this.name = name;
        this.planeNumber = planeNumber;
        count++;
        System.out.println("비행기가 생산되었습니다.\n비행기 이름 : " + name + "\n비행기 번호 : " + planeNumber);
    }

    public static void printCount() {
        System.out.println("현재까지 생산된 비행기 수는 " + count + "입니다.");
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "name='" + name + '\'' +
                ", planeNumber=" + planeNumber +
                '}';
    }

    public static void main(String[] args) {
        AirPlane airPlane1 = new AirPlane("대한항공", 707);
        AirPlane airPlane2 = new AirPlane("델타항공", 505);
        AirPlane.printCount();
    }
}



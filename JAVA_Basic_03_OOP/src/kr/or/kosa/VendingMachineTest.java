package kr.or.kosa;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine v1 = new VendingMachine(100, "혜화역 4번출구");
        VendingMachine v2 = new VendingMachine(200, "서울역 1번출구");

        v1.turnOnOff(true);
        v1.sell(5_000);
        v1.sell(1_000);
        v1.sell(500);
        v1.printInfo();

        v2.sell(10_000);
        v2.turnOnOff(true);
        v2.sell(1_000);
        v2.sell(500);
        v1.printInfo();


        VendingMachine.printCount();

    }
}

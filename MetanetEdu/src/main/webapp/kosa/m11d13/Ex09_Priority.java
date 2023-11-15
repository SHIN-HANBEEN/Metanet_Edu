package kr.or.kosa.m11d13;
/*
    쓰레드가 여러 개 있다면,
    개발자는 사실 쓰레드에 대한 조작이 가능한데요.
    경마 게임을 할 때, 특정 말이 더 빨리 달리도록 할 수 있는 것이죠.

    바로, 'priority' 우선순위를 달아주는 것입니다.
    default 는 5이며, min 1 ~ max 10 까지 부여할 수 있습니다.

    예를 들어, max 10 을 특정 thread 에게 부여하면,
    cpu를 점유할 수 있는 확률이 더 올라가게 됩니다.
    즉, 강제는 아닙니다.
 */
class Pth extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i ++) {
            System.out.println("===========================");
        }
    }
}
class Pth2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i ++) {
            System.out.println("|||||||||||||||||||||||||||||||");
        }
    }
}
class Pth3 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i ++) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }
}
public class Ex09_Priority {
    public static void main(String[] args) {
        Pth pth = new Pth();
        Pth2 pth2 = new Pth2();
        Pth3 pth3 = new Pth3();
        pth.setPriority(10); // priority 가 높은 것이 먼저 끝나게 됩니다.
        pth2.setPriority(1);
        pth3.setPriority(2);
        System.out.println(pth.getPriority());
        System.out.println(pth2.getPriority());
        System.out.println(pth3.getPriority());
        /*
            priority 는 기본값 5로 모두 같은
            값을 가지고 있습니다.
         */
        pth.start();
        //pth.stop(); // stop 을 하면, 프로그램이 강제 종료 될 수 있어서 쓰면 안됩니다.
        pth2.start();
        pth3.start();


    }
}

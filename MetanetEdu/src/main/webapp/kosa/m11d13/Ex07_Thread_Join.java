package kr.or.kosa.m11d13;
/*
    쓰레드는 내부적으로 상태 정보를 가지고 있습니다.
    예를들어, New 로 쓰레드를 생성한 다음 Start 를 해주게 되면 Runnable 상태로 들어가죠.

    그다음, Waiting, timed_waiting, blocked
    와 같은 상태가 더 있는데요.

    권장 사항이 하나 있습니다. 바로 강제 종료 금지인데요.
    논리상의 오류가 발생할 수 있기 때문에 이미 실행된
    쓰레드는 강제종료를 안하도록 권장됩니다.
 */
class Thread_1 implements Runnable {
    /*
        Runnable 을 구현한 클래스는 실제로 쓰레드는 아니라고 배웠죠.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ");
    }
}
public class Ex07_Thread_Join {
    public static void main(String[] args) {
        /*
            쓰레드를 재사용할 일은 거의 없기 때문에 아래의 두 가지 방법 중
            익명 객체를 사용하는 방법을 더 많이 사용한다.
            그래서 Runnable 을 구현한 클래스를 생성하는 것이 아니라
            바로 new Runnable 을 할 수 있습니다.
         */
        Thread th1 = new Thread(new Thread_1());
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ");
            }
        });
        Thread th3 = new Thread(new Thread_1());
        Thread th4 = new Thread(new Thread_1());
        Thread th5 = new Thread(new Thread_1());

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        System.out.println("main end 1");
        /*
            Thread 라는 것은 CPU의 시분할 방식에 따라서 어떤 것이 먼저 실행될지 알 수
            없습니다.
            만약 목성 까지의 거리를 구하는 쓰레드, 토성, 금성 까지의 거리 구하는 쓰레드
            3개 쓰레드를 만든 다음에 총합을 구하고 싶다면 어떻게 해야할까요?

            어떤 쓰레드가 먼저 끝날지 알 수가 없습니다.
            총 거리의 합을 구하는 쓰레드가 제일 마지막에 작업되도록 하고 싶은 거죠.

            위에서 만든 쓰레드가 거리를 구하는 쓰레드라고 해봅시다.

            우리는 현재, main 쓰레드 가 제일 먼저 실행되는데요.
            main 쓰레드는 5개의 쓰레드가 끝난 다음에 종료되기를 원하는거죠.
            지금 아무런 장치를 하지 않고 sysout 을 해주면, sysout 이 먼저 실행되버립니다.
         */
        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            th5.join();
            /*
                join 을 해주면, main 쓰레드에게 '내가 끝날 때까지 기다려' 라는
                의미입니다.
             */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("main end 2");

    }
}

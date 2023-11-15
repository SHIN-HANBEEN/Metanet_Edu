package kr.or.kosa.m11d09;
/*
    Thread
        프로세스에서 하나의 최소 실행 단위
        method
        실행되는 공간 stack

    결국...
        stack 여러 개를 생성해서
        동시에 함수를 실행

    Thread 생성방법
        1. Thread 클래스 상속
            run 함수를 오버라이드 해야 합니다.
        2. Runnable 인터페이스 구현
            run 추상 메서드 구현해야 합니다.
            Runnable 인터페이스는 Thread 가 아니라,
            Thread 를 넣어줘야 합니다.
            Thread thread = new Thread(new Task())
            와 같이 말이죠.

    Thread 는 추상 클래스가 아니라 그냥 클래스입니다.
        왜냐하면 Runnable 인터페이스의 new Thread( ) 를 해주어야 하는데,
        추상 클래스면 그렇게 할 수가 없기 때문입니다.
 */
class Task_1 extends Thread {
    @Override
    public void run() {
        /*
            이 함수는 Thread 의 main 함수 역할을 합니다.
            즉, thread 가 생성되고 제일 먼저 실행되는 메서드는 run( ) 인 것이죠.
            즉, 처음 stack 이 생성되고 제일 먼저 실행되는 메서드가 run( ) 입니다.

            Thread 가 생성되면 내부적으로 자동으로 이름이 부여되는데요. getName 으로
            확인할 수 있습니다.
         */
        for(int i = 0; i < 1000; i++) {
            System.out.println("Task_1 " + i + this.getName());
        }
        System.out.println("=================Task_1 run( ) END=================");
    }
}
class Task_2 implements Runnable {
    /*
        Task_2 는 Runnable 을 구현하는데요.
        Runnable 은 Thread 가 아닌, run 을 가지고 있는
        클래스일 뿐입니다.
        그래서 this.getName( ) 을 사용하지 못했죠.
     */
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("Task_2 " + i + "Task_2");
        }
        System.out.println("=================Task_2 run( ) END=================");
    }
}
public class Ex02_Multi_Thread {
    public static void main(String[] args) {
        /*
            main 메서드도 스레드고, stack 을 점유합니다.

            Thread 를 사용하기 위해서는 생성을 먼저 해야 합니다.
            그 다음 생성된 참조변수를 통해서 start( ) 를 실행해야 하는데요.
            start( ) 함수는 메모리를 할당 받는 역할을 합니다.
            start 함수는 Main 메서드의 스택 위에서 실행되는데요.
            실행 되자마자 또 다른 stack 메로리를 생성한 다음
            run( ) 함수를 올려주는 것 까지가 start( ) 함수의 역할입니다.
         */

        Task_1 th1 = new Task_1(); //Thread 객체를 생성
        th1.start(); //Start( ) 함수가 제일 중요한데요. 메모리를 만드는 역할을 수행합니다.
        /*
            새로운 스택을 생성한 다음 run( ) 함수가 올리고 끝입니다.
         */

        Thread th2 = new Thread(new Task_2());
        th2.start();
        /*
            인터페이스를 구현한 객체는 Thread 가 아니기 때문에 실제로 Thread 를 만들어야 합니다.
            new Thread(new Task_2()) 와 같이 생성하면 됩니다.
         */

        for(int i = 0; i < 1000; i++) {
            System.out.println("main " + i + "main");
        }
        System.out.println("=================main( ) END=================");

        /*
            여기까지 작성했다면,
            stack 이 3개 생성되는데요.
            stack 3개는 모두 Runnable 상태이기 때문에,
            서로 cpu 자원을 사용하기 위해 경쟁하게 됩니다.
         */

        /*
            그런데, Thread 객체는 한번 사용하고 다시 사용하지 않는데요.
            이런 특징 때문에 익명 객체를 주로 사용합니다.
         */
        //익명 객체입니다. 이 방법을 제일 많이 사용합니다.
        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    System.out.println("Task_3 " + i + "Task_3");
                }
                System.out.println("=================Task_3 run( ) END=================");
            }
        });
        th3.start();

        /*
            쓰레드를 임의로 일시 정지를 해줄 수 있는데요.
            sleep(시간) 을 주면 스레드가 일시정지합니다.
         */
    }
}

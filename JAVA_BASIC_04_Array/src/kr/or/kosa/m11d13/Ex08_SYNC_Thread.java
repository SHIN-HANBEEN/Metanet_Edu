package kr.or.kosa.m11d13;
/*
    여러 개의 쓰레드가 동작하면,
    어떠한 공유자원을 가지고 노는 경우의 문제가 발생합니다.
    이럴 때 우리는 synchronized 이 단어에 집중하게 됩니다.
    우리는 이 단어를 컬렉션 Collection 에서 들었습니다.
    Vector 와 Arraylist 에서 들었었죠.
    Vector 는 동기화가 기본인데, Arraylist 는 필요에 따라서 걸게
    하였습니다. 한강에 있는 비빔밥집과 화장실을 이야기했었죠.

    Vector 는 여러개의 쓰레드를 대비해서 동기화 보장합니다.
    멀티 쓰레드 환경에서 작업을 할 경우에 '자원을 보호'하자라는 생각을 합니다.
    예를들어, 화장실에 들어가면 락을 걸어서 다른 사람이 못들어가게 하는 거죠.
    순환이 빠르게 돌지 않기 때문에 성능의 제한이 걸리게 됩니다.
    문제는, 현대 프로그래밍에서는 동기화보다는 성능적인 측면을 고려합니다.
    성능이라는 것은 하나의 자원을 동시에 접근할 수 있게 해주는 것이죠.
    락을 걸지는 말고, 불평등은 감수하자! 라는 것이 ArrayList 입니다.
    쓰레드마다 자원을 점유하는 것이 불평등하게 돌아갈 수는 있다는 것이죠.

    한강에 있는 화장실이 공유자원이라면, 하나 밖에 없다고 해봅시다.
    사용하려는 사용자들을 쓰레드라고 생각해봅시다. 예를 들어 사람이 10명이라면
    10개의 쓰레드가 있는 것이죠. 이 10명의 사용자들이 동시에 화장실에 접근하는 것이죠.
    이 시나리오를 가지고 프로그램을 작성해봅시다.
 */

class Wroom {
    //void openDoor(String name) { //동기화 X
    synchronized void openDoor(String name) { //동기화 O
        System.out.println(name + "님 화장실 입장");
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "님이 사용 중 : " + i);
            if (i == 10) {
                System.out.println(name + "님이 끙 @@");
            }
        }
        System.out.println("시원하시죠 ^^");
    }
}
class User extends Thread {
    Wroom wr;
    String who;
    User(String name, Wroom wr) {
        this.who = name;
        this.wr = wr;
    }
    @Override
    public void run() {
        wr.openDoor(who);
    }
}
public class Ex08_SYNC_Thread {
    public static void main(String[] args) {
        Wroom wroom1 = new Wroom();
        User user1 = new User("유저1", wroom1);
        User user2 = new User("유저2", wroom1);
        User user3 = new User("유저3", wroom1);

        user1.start();
        user2.start();
        user3.start();
        /*
            이렇게 하면, 공유 자원(화장실)을 함께 쓰기 때문에, 화장실을
            같이 들어가서 같이 사용하게 됩니다.
            이게 바로 Lock 이 없는 상태의 코드입니다.

            어느 누가 화장실에 들어가면 다른 사람이 못들어가게
            하고 싶습니다.

            이게 바로 동기화입니다.
            동기화는 객체동기화 & 함수 동기화가 있는데,
            객체동기화는 어렵습니다.
            함수 동기화는 간단하죠.
            바로 synchronized 입니다.

            일상생활에서는 어떤 예시가 있을까요??

            여러분이 헷갈리는 것 중에 트랜잭션과 동기화가 있는데요.
            트랜잭션이란 것은 무엇인가요?
            트랜잭션은 '하나의 논리적인 작업 단위'입니다.

            DB 입장에서는 begin tran 을 했으면,
            rollback 과 commit 둘 중 하나는 무조건 실행 되어야 하죠.

            Spring 에서는 transaction annotaion 이 있고 자바에서도
            있습니다.

            예를 들어 다음과 같다고 해보죠.
            Begin tran
                A 계좌 인출
                B 계좌 이체
            rollback
            commit
            위와 같이 논리적 단위가 되는 것이죠.

            트랜잭션은 매우 중요합니다.
            예를 들어 장바구니에 담은 다음에 구매까지 가는 단위는
            하나의 논리 단위로 묶어버리는데요.
            중간에 어떠한 에러가 발생하면 다시 처음으로 되돌려 주어야
            하기 때문이죠.

            ATM 도 대표적인 예시입니다.
            한 계좌의 카드를 여러 개 만들어놓고 동시에 돈을 인출하는 것을
            막아 버리는 것이죠.
         */
    }
}

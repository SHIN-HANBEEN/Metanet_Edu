package kr.or.kosa.m11d13;
/*
    DaemonThread 라는 것은 보조 쓰레드라는 의미와 같습니다.
    주 쓰레드가 글을 쓰는 것이고,
    3초마다 글을 자동 저장하는 것이라면,
    3초마다 글을 자동 저장하는 쓰레드는 보조 쓰레드이고,
    메인 쓰레드가 종료되면 같이 종료됩니다.
 */
class AutoSaveThread extends Thread {
    public void save() {
        System.out.println("작업 내용을 자동으로 저장합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000); //2초 sleep 시켜주기
            } catch (Exception e) {
                break;
            }
            save(); //2초마다 save 가 자동으로 실행됩니다.
        }
    }
}
public class Ex10_DaemonThread {
    public static void main(String[] args) {
        /*
            주 쓰레드는 main 함수라고 해볼게요!
         */
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        /*
            setDaemon(true) 를 하면, 이 쓰레드를 만든 쓰레드의
            보조 쓰레드가 됩니다. 현재 상황에서는 Main 쓰레드가 사라지면
            함께 사라지는 쓰레드가 되는 것이죠.
         */
        autoSaveThread.start();

        try {
            Thread.sleep(5000);
            /*
                main 쓰레드가 휴식에 들어가도, daemon 쓰레드는
                계속 돌아갑니다.
             */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Main 쓰레드 종료!");
    }
}

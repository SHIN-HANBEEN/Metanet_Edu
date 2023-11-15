package kr.or.kosa.m11d09;

import javax.swing.*;

/*
    두 개의 함수가 동시에 실행이 안되네?
    야 그러면, 스택이 여러개 있으면 되잖아!
    멀티 쓰레드를 사용하겠다는 겁니다.

    문제와 시간이 별도의 쓰레드로 실행이 되면서,
    두 개의 쓰레드가 동시에 실행되야 합니다.
 */
class WordTimeThread extends Thread {
    @Override
    public void run() {
        for(int i = 10; i > 0; i--) {
            if (Ex04_Multi_Word_Game.check) {
                return; //만약 check 값이 true 면 종료시킨다.
            }
            try {
                System.out.println("남은 시간 : " + i);
                Thread.sleep(1000); // 1000ms = 1s //sleep( ) 은 Thread 의 static 메서드입니다.
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class WordInputThread implements Runnable {

    @Override
    public void run() {
        String dan = "2";
        String inputdata = JOptionPane.showInputDialog(dan + "단 값을 입력하세요.");
        /*

         */
        if(!inputdata.isEmpty()) {
            Ex04_Multi_Word_Game.check = true; // 사용자가 단어를 입력하면 타이머도 멈추게 된다.
        }
        System.out.println("입력값 : " + inputdata);
    }
}
public class Ex04_Multi_Word_Game {
    static boolean check = false; //시간이 다 지나면 종료되도록 static 자원 설정
    public static void main(String[] args) {


        WordTimeThread wordTimeThread = new WordTimeThread();
        wordTimeThread.start(); // start 메서드는 run 만 새로운 stack 메서드에 올리고 Main 메서드의 Stack 영역에서 바로 빠지기 때문에 어떤 스레드가 먼저 끝나던 main 스택 영역과는 무관합니다.
        Thread WordInputThread = new Thread(new WordInputThread());
        WordInputThread.start();

        System.out.println("==============Main END===============");
    }
}

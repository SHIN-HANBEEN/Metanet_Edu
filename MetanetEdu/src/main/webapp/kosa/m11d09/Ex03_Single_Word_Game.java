package kr.or.kosa.m11d09;

import javax.swing.*;

/*
    [ 단어 맞추기 or 구구단 게임 ]
    문제가 나오고 시간이 나오는 것을 하고 싶은데요.
    예를 들어서, 일정 시간이 지나면 종료를 시켜주고 싶습니다.
    밑의 코드를 보면, 사용자가 입력을 해주기 전까지는 시간이 흘러가지 않습니다.
    싱글 스레드 만으로는 이런 기능을 절대 구현할 수 없는 것이죠.
    이럴 때 바로 멀티쓰레드로 가야 합니다.

    예전에 Swing 이라는 것이 있는데요.
    지금은 안쓰는 기술입니다. 그것을 사용하면 윈도우의 다양한 기술들을 접근할 수 있습니다.
 */
public class Ex03_Single_Word_Game {
    public static void main(String[] args) {
        String inputdata = JOptionPane.showInputDialog("값을 입력하세요.");
        System.out.println("입력값 : " + inputdata);
        timer();
    }
    static void timer() {
        for(int i = 10; i > 0; i--) {
            try {
                System.out.println("남은 시간 : " + i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package kr.or.kosa;

class Test2 {
    static int cv = 10;
    static int cv2; //default 0
    int iv = 9;

    /*
        초기화 블럭
        { } 요거는 생성자의 존재 때문에 잘 사용하지는 않는다.
        static { } 요거는 생성자를 활용할 수 없는 클래스 변수들을 위해 효과적이라서 자주 쓴다.
        조작된 값을 초기화 과정에서 활용할 수 있기 때문에 자주 쓰게 됩니다.
        제어문을 사용할 수 있는게 대표적이겠습니다.
     */

    static {
        cv2 = cv + 2222;
    }
}
public class Ex06_Static {
    public static void main(String[] args) {

    }
}

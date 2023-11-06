package kr.or.kosa;

class System2 {
    static Out2 out2;

    static {
        out2 = new Out2();
    }
}

final class Out2 {
    static void println(String text){
        System.out.println(text);
    };
}
public class Test {
    public static void main(String[] args) {
        System2.out2.println("안녕하세요.");
    }
}

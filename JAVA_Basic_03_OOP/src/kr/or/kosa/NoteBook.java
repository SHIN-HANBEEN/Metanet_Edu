package kr.or.kosa;

/*
    우리 객체지향의 목적은 이쁜 설계도를 만드는 것이다.
    나중에 유지보수를 잘하기 위한 것이 목적이다.

    노트북은 색상을 가지고 있다.
    노트북은 생산년도를 가지고 있다.
    노트북은 마우스를 가지고 있다.
    마우스는 휠 1개, 버튼 2개, 좌표값을 가지고 있다.
 */

class Position {
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class Mouse {
    private int Wheel;
    private int Button;
    private Position position;

    Mouse(Position position) {
        this.Wheel = 1;
        this.Button = 2;
        this.position = position;
    }

    Mouse() {
        this.Wheel = 1;
        this.Button = 2;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "Wheel=" + Wheel +
                ", Button=" + Button +
                ", position=" + position +
                '}';
    }
}
public class NoteBook {
    private String color;
    private int year;
    private Mouse mouse;
    /*  private Mouse mouse = new Mouse();
        위와 같이 초기화를 직접 해준다는 의미는, NoteBook 과 Mouse 의 라이프 사이클이 정확히 같다는 것을 의미하며,
        말로 풀어서 말하자면, NoteBook 에는 Mouse 가 설치되어 있다라고 할 수 있다.

        만약 mouse 를 가질 수도 안가질 수도 있다 라고 주어졌다면, 다음과 같이 코드가 바뀌게 된다.

        public void handleMouse(Mouse m) {
            m.setX(100);
            m.setY(200);
            m.toString();
        }
        위와 같이 코드를 작성하면 노트북은 출고 당시 마우스를 가지고 있지 않지만,
        notebook.handleMouse(m)
        을 실행하면 직접 가지지는 않지만 마우스를 갖게 된다.

        위와 같은 관계를 '의존' 관계라고 합니다.
        NoteBook 객체는 필요에 따라서 Mouse 를 받을 수 있게 되는 것이죠.
     */
    NoteBook(String color, int year, Mouse mouse) {
        this.color = color;
        this.year = year;
        this.mouse = mouse;
    }

    NoteBook(String color, int year) {
        this.color = color;
        this.year = year;
    }

    public void handleMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "color='" + color + '\'' +
                ", year=" + year +
                ", mouse=" + mouse +
                '}';
    }
}

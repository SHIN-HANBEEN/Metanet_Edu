package kr.or.kosa;

public class Ex03_Method_Ref {
    public static void main(String[] args) {
        Position position = new Position(10, 20);
        Mouse mouse = new Mouse(position);
        NoteBook noteBook = new NoteBook("blue", 2023, mouse);

        Position position1 = new Position(20, 30);
        Mouse mouse1 = new Mouse();
        NoteBook noteBook1 = new NoteBook("red", 2023);
        noteBook1.handleMouse(mouse1);
    }
}

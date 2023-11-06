package kr.or.kosa;
/*
    어노테이션은 자바에서 컴파일러어게 문법 체크,
 */
class Point2 {
    int x = 4;
    int y = 5;

    String getPosition() {
        return this.x + "/" + this.y;
    }
}

class Point3D extends Point2 {
    int z = 6;

    @Override //컴파일러에게 문법 체크 하도록 강제한다.
    String getPosition() {
        return super.getPosition() + "/" + this.z;
    }
}

public class Ex03_Inherit_override {

    public static void main(String[] args) {
        Point3D p = new Point3D();
        String result = p.getPosition();
        System.out.println(result);

    }

}


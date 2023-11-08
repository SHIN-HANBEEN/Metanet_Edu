package kr.or.kosa.before;

class Shape {
    String color = "grid";
    void draw() {
        System.out.println("도형을 그리다.");
    }
}

class Point {
    int x;
    int y;

    Point() {
        this(1, 1);
    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

/*
    원을 만들어봅시다.
    원은 한 점과 반지름을 가지고 있습니다.
    1. 원은 도형이다 (is ~ a) : Shape
    2. 원은 점을 가지고 있다 (has ~ a) : Point
    3. 원의 특수화 되고 구체화 된 것만 제시합니다. : 반지름

    원은 반지름 초기값 10을 가진다.
    점의 좌표는 10, 15 이다.
    초기값을 설정하지 않으면 반지름과 점의 값을 입력받을 수 있다.
 */
class Circle extends Shape {
    Point point; // 포함 > 부품
    int r; // 구체화, 특수화

    Circle() {
        //this.r =  10;
        //this.point = new Point(10, 15);
        this(10, new Point(10, 15));
    }

    Circle(int r, Point point) { //Point 라는 객체의 주소가 들어와야 한다.
        this.r = r;
        this.point = point;
    }
}

/*
    삼각형 클래스를 만드세요.
    삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다.
 */
class Triangle extends Shape {
    Point[] points;

    Triangle() {
        this(
                new Point[] {
                    new Point(1,1),
                    new Point(2,2),
                    new Point(3,3) },
                "green" );
    }

    Triangle(Point[] points, String color) {
        this.points = points;
        this.color = color;
    }

    @Override
    void draw() {
        for (Point point : points) {
            System.out.println(point);
        }
        System.out.println("세 점을 이용한 삼각형을 그립니다.");
        System.out.println(color + "색을 그렸습니다.");
    }
}


public class Ex02_Inherit_Composition {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.r);
        System.out.println(circle.color);
        System.out.println(circle.point.x); //주소값.주소값.field
        System.out.println(circle.point.y);

        Point[] points = {new Point(1,1), new Point(2,2), new Point(3,3)};
        Triangle triangle = new Triangle(points, "black");
        triangle.draw();
    }
}

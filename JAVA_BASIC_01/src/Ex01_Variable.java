import kr.or.kosa.Emp;

// 클래스는 2가지로 나뉜다. main 함수가 있는 클래스와 없는 클래스.
// main 함수가 없는 클래스는 다른 클래스를 위해서 존재하며, 이것을 우리는 '라이브러리 클래스'라고 부른다.
// 제일 작은 블럭을 갖는 변수는 제어블럭 안에 있는 변수입니다.
// 클래스 == 설계도 == 데이터 타입
public class Ex01_Variable {
    public static void main(String[] args) {
        int value = 100;
        System.out.println(value);

        int age = 99;

        Test test = new Test();
        System.out.println(test.data);

        Emp emp; // emp 라는 지역변수는 Emp 라는 클래스의 참조값을 가질 준비가 된 것이다.
        emp = new Emp();
        emp.setEmpno(100);
        int empvalue = emp.getEmpno();
        System.out.println(empvalue);

        int a, b, c;
        // 같은 타입 나열이기 때문에 배열을 사용합니다.

        int[] arr = new int[3];
        System.out.println(arr[0]);
    }
}

class Test {
    int data;
}

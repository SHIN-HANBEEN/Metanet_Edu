import kr.or.kosa.Person;

class Test {
    int i;
    int j;
    void print() {
        System.out.println(i);
    }
}

public class E01_Ref_Type {
    public static void main(String[] args) {
        /*
            타입은 값타입과 참조타입으로 나뉘어져 있습니다.
            참조타입은 stack 영역에 값이 아니라, 주소값을 가지고 있습니다.
            우리가 만든 클래스 타입, 배열, String 등등이 있습니다.

            현재 위에 있는 Test 클래스를 사용하지 않았다면 종이에 불과합니다.
         */

        Test test = new Test();
        System.out.println(test);
        test.print();

        Person person = new Person(); //생성자 함수를 호출하면서 메모리에 올리겠다는 것을 의미합니다.
        person.name = "김유신";
        person.age = 100;
        person.power = true;
        person.personPrint();

        System.out.println(person);
        System.out.println(person.toString()); //컴파일러가 자동적으로 .toString( )을 붙여준다.

        Person person1 = new Person();
        System.out.println(person == person1);

        Person person2 = person;
        System.out.println(person == person2);

        /*
            클래스 == 설계도 == 데이터 타입(사용자 정의)
         */
    }
}

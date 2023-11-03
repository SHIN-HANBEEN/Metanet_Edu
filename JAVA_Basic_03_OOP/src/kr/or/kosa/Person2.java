package kr.or.kosa;

public class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    /*
        getter 만 만드는 것의 의미는,
        초기화를 생성자만을 통해서 하도록 제한하겠다는 의미입니다.
        또한, default 생성자는 만들지 않았다는 의미는 강제로 초기화를 하겠다는 의미다.
        만약, toString( )을 오버라이딩 해놓았다면 getter 는 사실 필요하지 않고,
        고객이 각각의 필드를 참조하는 것을 원하면 getter 를 만들어 주는 것이다.
     */

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

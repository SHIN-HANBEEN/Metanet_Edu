package kr.or.kosa.before;

class Pbase {
    int p = 100;
}

class Cbase extends Pbase {
    int c = 200;
}

class Dbase extends Pbase {

}
public class Ex09_Inherit_Polymorphism {
    public static void main(String[] args) {
        /*
            상속 관계에서 부모타입의 참조변수는 여러개의 자식타입 주소를 가질 수 있다.
            MS, C# 과는 다른 부분이죠.
         */
        Cbase cbase = new Cbase();
        System.out.println(cbase.toString());

        /*
            다형성
         */
        Pbase pbase = cbase;
        Dbase dbase = new Dbase();
        pbase = dbase;

        /*
            자식은 부모에게 조건없이 다 줄 수 있는데,
            부모가 자식한테 줄 때는 문제가 생깁니다.
            다운캐스팅 & 강제캐스팅
         */
        //Cbase ccc = pbase;
        Cbase ccc = (Cbase)pbase;
    }
}

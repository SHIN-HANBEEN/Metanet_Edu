package kr.or.kosa;
/*
    배열은 객체다 (Array)
        1. new 를 통해서 생성
        2. heap 메모리 생성
        3. 정적배열(고정배열) : 배열은 한번 선언하면 (크기가 정해지면) 변경 불가 vs 동적 배열 : Collection
            사실 Collection 도 내부적으로는 정적 배열을 사용합니다.
            JS 는 정적 배열이 없고 모두 동적 배열입니다.
        4. 자료구조(알고리즘) : 제어문(결합) : 기초적인 자료구조
            알고리즘에 배열을 계속 사용합니다.
 */

class Carex {

}
class PersonEx {
    String name;
}
public class Ex01_Array {
    public static void main(String[] args) {
        int[] arr = new int[5]; //배열은 객체다. 즉, 5개의 방은 heap 에 만들어진다.
        int[] arr2 = new int[] {10, 20, 30, 40}; //생성과 동시에 초기화
        int[] arr3 = {10, 20, 30, 40}; //생성도 안하고 바로 초기화? -> 생략된 것으로 컴파일러가 알아서 new 를 붙인다.

        //Tip for JS
        /*
            const arr = [1, 2, 3, 4, 5]
            let arr = [];
            arr.push(10);
            자바스크립트는 타입이 없으니까 상수로 만들어버린다. 자바와 다른 점은 [ ] 를 사용한다.
            자바스크립트는 배열이 스택이다. 즉, push( )를 통해서 넣어주게 된다.

            자바스크립트는 동적 배열이라는 점 알고 있어봅시다.
         */

        /*
            배열에서 가장 중요한 것은 객체배열입니다.
         */
        Carex[] cararr = new Carex[3];
        cararr[0] = new Carex();

        //향상된 for 문
        /*
            JAVA : for(Type 변수명 : 배열 or 컬렉션) { }
                내부적으로는 While 문이 돌아가고 있습니다.
                하나씩 배열에서 받아서 출력합니다.

            C# : for(Type 변수명 in 배열 or 컬렉션) { }

            JS : for(Type 변수명 in 배열 or 컬렉션) { }
         */
        int[] arr4 = {5, 6, 7, 8, 9};
        for(int i : arr4) {
            System.out.println(i);
        }

        Person[] arr5 = new Person[3];
        arr5[0] = new Person();
        arr5[1] = new Person();
        arr5[2] = new Person();
        /*
            위와 같이 하는 것은 좀 비효율적이죠~
         */

        Person[] arr6 = {new Person(), new Person(), new Person()};
        /*
            위와 같이 쓰는게 가장 효율적입니다.
         */
    }
}

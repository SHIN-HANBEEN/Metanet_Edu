package kr.or.kosa.m11d07;

import java.util.ArrayList;
import java.util.Stack;

/*
    제네릭 설계도를 살펴보겠습니다.

 */
class Mygeneric<T> { //T = 관용적으로 Type 을 의미합니다.
    T obj;
    void add(T obj) {
        this.obj = obj;
    }

    T get() {
        return this.obj;
    }
}

class Person {
    int age = 100;
}
public class Ex02_Generic {
    public static void main(String[] args) {
        Mygeneric<Person> mygeneric = new Mygeneric<>();
        mygeneric.add(new Person());
        /*
            Person obj;
            void add(Person obj) {
                this.obj = obj;
            }

            Person get() {
                return this.obj;
            }
         */

        /*
            이렇게 값을 꺼내는 편리함 때문에,
            ArrayList 도 제네릭을 사용합니다.
         */
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person());

        Stack<Integer> mystack = new Stack<>();
        mystack.push(10);
    }
}

package kr.or.kosa.m11d07;

import java.util.EmptyStackException;

public class KStack {
    private Object[] stackarr; //stack 저장소
    private int position; //배열의 마지막 요소 index 위치정보값
    private int maxsize; //배열의 최대 크기

    public KStack() { //기본적으로 10의 크기로 초기화한다.
        this(10);
    }
    public KStack(int maxsize) {
        this.stackarr = new Object[maxsize];
        this.position = -1;
        this.maxsize = maxsize;
    }

    public boolean isEmpty() {
        return size() == -1;
    }

    public boolean isFull() {
        return (position == this.maxsize -1);
    }

    public int size() {
        return (stackarr.length -1);
    }

    public Object push(Object item) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Stack 이 Full 상태입니다.");
        } else {
            stackarr[++position] = item;
        }
        return item;
    }
    public Object peek() {
       int len = size();
       if(isEmpty()) {
           throw new EmptyStackException();
       }
       return stackarr[len];
    }
    public Object pop() {
        Object obj = peek(); //stack 의 저장된 마지막 요소 읽어오기
        int len = size();
        /*
            만일 Stack 이 비어있으면 peek( ) 메서드가 EmptyStackException 을 발생시킨다.
            마지막 요소를 삭제하고, return 해주면 된다.
         */
        stackarr[len] = null; //마지막 요소 삭제.
        position--; //배열의 index 값 감소
        return obj;
    }

    public int search(Object o) {
        int index= -1; //값을 찾으면 index 값을 대입받는다. 초기값은 -1로 잡아놓는다.
        for (int i = size(); i == 0; i--) { //마지막 요소부터 찾기 시작한다.
            if(stackarr[i] == o) {
                index = i;
            }
        }
        if(index >= 0) { //만약 객체를 찾은 경우
            return size();
        }
        return -1; //만약 객체를 찾지 못하면 -1 을 반환한다.
    }
}

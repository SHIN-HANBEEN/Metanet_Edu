package kr.or.kosa;

/*
    함수는 한 가지 기능을 하나의 함수가 구현한다.
    함수에는 4가지 밖에 없다.
    void - parameter(o)
    void - parameter(x)
    return type - parameter(o)
    return type - parameter(x)

    메서드를 처음 접하는 분이 제일 어려워하는 부분은 객체를 데이터 타입으로 인정하는 부분입니다.
 */
class Fclass {
    private int subSum(int i) { //클래스 내에서만 사용하는 private 함수인데, 다른 함수를 도와주는 함수라는 의미이다. 공통함수!
        return i + 100;
    }

    public int max(int i, int j) {
        return (i > j) ? i : j;
    }

    public int max2(int i, int j) {
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }
    /*
        max 와 max2 중에 뭐가 좋은 것일까? 바로 return 이 적은 max 함수이다.
        return 문이 많은 코드는 유지보수하기가 굉장히 힘들어진다.
     */
}

public class Ex02_Method_Call {
    public static void main(String[] args) {
        Fclass fclass = new Fclass();
        System.out.println(fclass.max(10, 50));
    }
}

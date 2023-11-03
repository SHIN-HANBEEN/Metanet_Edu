package kr.or.kosa;

/*
    Lotto.java 클래스를 만드시고
    1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
    2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요.]
    3. 배열에 담긴 값을 출력하세요.
 */

class Lotto {
    int num;
}

public class Ex02_Lotto {
    public static void main(String[] args) {
        int[] lottoarr = new int[6];

        for (int i = 0; i < lottoarr.length; i++) {
            lottoarr[i] = (int)(Math.random()*45) + 1; //1~45 난수 생성
            for (int j = 0; j < i; j++) {
                if(lottoarr[i] == lottoarr[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < lottoarr.length; i++) {
            lottoarr[i] = (int)(Math.random()*45) + 1; //1~45 난수 생성
            for(int j = 0; j < i; j++) {
                if(lottoarr[i] == lottoarr[j]) { //중복 방지
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < lottoarr.length; i++) { //정렬
            for(int j = i+1; j < lottoarr.length; j++) {
                if(lottoarr[i] > lottoarr[j]) {
                    int temp = lottoarr[i];
                    lottoarr[i] = lottoarr[j];
                    lottoarr[j] = temp;
                }
            }
        }

//        for (int i = 0; i < lottoarr.length; i++) { //정렬
//            if(lottoarr[i] > lottoarr[i+1]) {
//                var = lottoarr[i+1];
//                lottoarr[i+1] = lottoarr[i];
//                lottoarr[i] = var;
//            }
//        }

        for (int j : lottoarr) { //출력
            System.out.println(j + "\t");
        }
    }
}

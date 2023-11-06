package kr.or.kosa;

public class Ex03_Array_Rank {
    /*
        다차원 배열 (2차원만)
        [행] [열]
        일상 어디서 사용될까?
        엑셀 시트, 영화 좌석, 지도 좌표, 바둑판 등등

        int[][] score = new int[3][2];
        3행 2열 짜리 다차원 배열이 생성되었습니다.

        초기화는 어떻게 진행될까요?
        score[0][0] = 100;

        //다차원 배열 >> 중첩 for
        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[i].length; j++) {
                System.out.printf("score [%d][%d] = [%d]\n", i, j, score[i][j]");
            }
        }

        int[][] score2 = new int[][] {{11,12}, {13,14}, {15,16}}
        //개선된 for문
        for(int[] arr : score2) {
            for(int value : arr) {
                System.out.println(value);
            }
        }
     */


}

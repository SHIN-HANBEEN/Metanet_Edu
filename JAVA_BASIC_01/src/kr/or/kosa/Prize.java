package kr.or.kosa;

public class Prize {
    public static void main(String[] args) {
        int score = (int)(Math.random() * 10) + 1; // 1 ~ 10의 정수 출력
        StringBuffer prize = new StringBuffer();
        switch (score) {
            case 10: prize.append("TV");
            case 9: prize.append("NoteBook");
            case 8: prize.append("냉장고");
            case 7: prize.append("한우세트");
            case 6: prize.append("휴지");
            default: prize.append("칫솔");
        }
        System.out.println(prize);
    }
}

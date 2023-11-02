import java.util.Scanner;

/*
    달력은 1월 부터 12월 까지 있다.
    각 달은 각각 정해진 일수를 가지고 있다.
    단, 2월은 28일을 갖는다고 가정한다.

    이중 for문과 배열 그리고 조건문을 활용하여 달력을 출력해보자.
    예를 들어, 사용자가 2를 입력하면 2월달 달력을 출력하는 식이다.

    풀이 조건.
    1. 이중 배열 활용
    2. 각 월의 시작 요일은 일요일이라고 가정한다.
    3. % 와 / 연산자를 활용한다.
    4. 달력 형식으로 출력할 때는 \t 를 활용하여 표의 형식으로 출력한다.
 */
public class Ex_FlowChart01 {
    public static void main(String[] args) {
        int month = 0;
        int days = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("보고 싶은 달을 입력하세요.");

        while (true) {
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("잘못된 달을 입력하였습니다. 다시 입력하세요.");
            } else {
                switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12 :
                        days = 31;
                        break;
                    case 2 :
                        days = 28;
                        break;
                    case 4, 6, 9, 11 :
                        days = 30;
                        break;
                }

                int weeks = 0; // 각 월의 주(week)의 개수

                if ((days % 7) == 0) { // 7일 단위로 월의 일수가 딱 나눠진다면,
                    weeks = (days / 7);
                } else { // 7일 단위로 월의 일수를 나눴을 때 나머지가 있다면,
                    weeks = (days / 7) + 1;
                }

                int[][] calendar = new int[weeks][7]; // 이중 배열로 각 요일에 알맞은 일을 넣어준다.

                System.out.println(month + " 달력을 출력합니다.");
                System.out.println("일\t월\t화\t수\t목\t금\t토");
                outer : for (int i = 0; i < weeks; i++) {
                    for (int j = 0; j < 7; j++) {
                        if(days <= 0) {break outer;}
                        calendar[i][j] = (7*i) + (j + 1);
                        days--; // 일의 숫자 만큼만 달력에 출력해야 하기 때문에 days-- 를 해준다.
                    }
                }

                for (int i = 0; i < weeks; i++) { // 이중 배열 출력
                    for (int j = 0; j < 7; j++) {
                        if (calendar[i][j] != 0) { // 이중 배열에 0으로 초기화 되어 있는 경우 0을 출력하지 않고 공백 출력.
                            System.out.print(calendar[i][j] + "\t");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
}


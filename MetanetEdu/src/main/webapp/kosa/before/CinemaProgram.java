package kr.or.kosa.before;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Cinema { //로또 처럼 클래스 설계
    String[][] seat;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, String> reservationmap;

    Cinema() {
        seat = new String[4][5];
        reservationmap = new HashMap<>();
        clearSeat();
    }

    //좌석 초기화
    void clearSeat() {
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length; j++) {
                seat[i][j] = "[" + i + "-" + j + "]";
            }
        }
    }

    //좌석 현황
    void printSeat() {
        System.out.println("******좌석 현황******");
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length; j++) {
                System.out.printf("%s", seat[i][j].equals("예매") ? "예매" : seat[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }


    //예매하기
    int makeReservation(Cinema cinema, Customer customer) { //cinema 객체를 받음
        int selectedMenu = 999;
        Random r = new Random();

        System.out.println("좌석을 선택해주세요. 예)1-1" +
                "\n이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
        String seatString = sc.nextLine();
        String seatRow = String.valueOf(seatString.charAt(0));
        String seatLow = String.valueOf(seatString.charAt(2));
        String seatValue = seat[Integer.parseInt(seatRow)][Integer.parseInt(seatLow)];

        if(seatValue.equals("예매")) {
            System.out.println("선택하신 좌석인 이미 예매되었습니다.");
        } else {
            System.out.println("예매 가능합니다. 예매하시겠습니까?");
            System.out.println("네(1), 아니오(2), 초기화면(0) 중 하나를 입력해주세요.");
            selectedMenu = sc.nextInt();
        }

        switch (selectedMenu) {
            case 1 : { //예매하시는 고객님 처리
                String ran = Integer.toString(r.nextInt(8) + 1);
                for (int i = 0; i < 7; i++) {
                    ran += Integer.toString(r.nextInt(9));
                }
                System.out.println("예매가 완료되었습니다.");
                System.out.println("예매한 좌석번호 : [" + seatRow + "-" + seatLow + "]");
                System.out.println("예매번호 : " + ran);

                customer.reservationNum = Integer.parseInt(ran);
                reservationmap.put(customer.reservationNum, seatRow + "-" + seatLow); //Map 에 예약번호와 좌석번호 저장

                return 1;
            }
            case 2 : {
                System.out.println("예매가 취소되었습니다.");

                return 2;
            }
            case 3 : {
                System.out.println("초기화면으로 돌아갑니다.");

                return 3;
            }
        }
        return 999;
    }

    //

    //예매내역 조회
    String findReservation(int reservationNum) {
        return reservationmap.get(reservationNum);
    }

    //예매 취소
    void cancelReservation(int reservationNum) {
        if(reservationmap.containsKey(reservationNum)) {
            reservationmap.remove(reservationNum);
        } else {
            System.out.println("잘못된 예매번호를 입력하셨습니다.");
        }
    }
}

class Customer {
    static int countcustomer;
    int customernum;
    int reservationNum;

    Customer() {
        this.customernum = countcustomer;
        countcustomer++;
    }
}

public class CinemaProgram {
    public static void main(String[] args) {
        boolean onOff = true;
        Scanner sc = new Scanner(System.in);
        int selectedMenu = 0;
        int selectedCase = 0;

        Cinema cinema = new Cinema();
        cinema.clearSeat(); //좌석 초기화

        Customer customer = new Customer();

        outer : while(onOff) {
            System.out.println("*********************");
            System.out.println("**영화 예매 시스템**");
            System.out.println("*********************");
            System.out.println("1. 예매하기");
            System.out.println("2. 예매조회");
            System.out.println("3. 예매취소");
            selectedMenu = sc.nextInt();

            switch (selectedMenu) {
                case 1 : { //예매하기 메뉴 선택
                    cinema.printSeat();
                    selectedCase = cinema.makeReservation(cinema, customer);
                    switch (selectedCase) {
                        case 1, 2: { //예매한 고객, 취소한 고객
                            //onOff = false;
                            break ;
                        } //메인 메뉴
                        case 3 : { //메인 메뉴선택한 고객
                            break;
                        }
                    }
                    break ;
                }
                case 2 : { //예매조회 메뉴 선택
                    System.out.println("예매번호를 입력해주세요.");
                    String seat = cinema.findReservation(sc.nextInt());
                    System.out.println("고객님이 예매하신 좌석은 " + seat + "입니다.");
                    break ;
                }
                case 3 : { //예매취소 메뉴 선택
                    System.out.println("예매번호를 입력해주세요.");
                    String seat = cinema.findReservation(sc.nextInt());
                    System.out.println("고객님이 예매하신 좌석은 " + seat + "입니다.");
                    System.out.println("예매를 취소하시겠습니까?");
                    System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
                    selectedCase = sc.nextInt();
                    if(selectedCase == 1) {
                        cinema.cancelReservation(customer.reservationNum);
                        System.out.println("정상적으로 예매가 취소되었습니다.");
                    }
                    break ;
                }
            }
        }
    }
}


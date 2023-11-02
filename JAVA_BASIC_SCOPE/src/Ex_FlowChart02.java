/*
    한 어린이가 공놀이를 한다.
    공을 10m의 높이에서 떨어뜨리는 놀이인데, 풍향에 따라서 공이 튀기는 방향이 영향을 받는다.

    예를 들어, 좌로 1m/s 로 바람이 불고 있다면, 공은 바닥에 닿는 시점에 좌로 10m 이동한다.

    각 초마다 바람이 1~10의 랜덤한 풍향과 방향으로 분다고 가정했을 때,
    최종적으로 바닥에 떨어지는 위치를 화면에 출력하라.

    조건
    1. 바람은 좌, 우로만 분다고 가정한다.
    2. 바람의 방향은 Math.random() 를 통해서 랜덤으로 생성된 풍향이 5m/s 보다 낮거나 같다면
       좌로 불고, 그렇지 않다면 우로 분다.

 */

public class Ex_FlowChart02 {
    public static void main(String[] args) {
        int result = 0; //최종 위치 값을 저장할 변수
        int speed = 0; //순간적인 풍향을 저장할 변수

        for (int i = 0; i < 10; i ++) {
            speed = (int)(Math.random() * 10) + 1;
            if(speed <= 5) {
                result -= speed;
                System.out.println("순간적으로 바람이 " + speed + "의 속도로 좌로 붑니다.");
            } else {
                result += speed;
                System.out.println("순간적으로 바람이 " + speed + "의 속도로 우로 붑니다.");
            }
        }

        System.out.println("최종적으로 공이 " + result + "m에 떨어졌습니다.");
    }
}

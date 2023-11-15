package kr.or.kosa.m11d08.Ex01_Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
    컴퓨터에서 가장 느린 작업은 : Disk read or write 입니다.
    File 처리는 disk 에 결국 작업을 한다는 이야기인데요.
    disk 에 한 바이트 단위로 작업하고 있는데요. 굉장히 비효율적이죠.
    한번에 보내서 써버리면 참 편할텐데 말이죠.

    대형 버스를 이용해서 보내면 좋은데요.
    이런 대형 버스의 역할을 하는 것이 Buffer 입니다.
    접근 횟수를 줄일 수 있구요.
    Line 단위의 작업을 할 수 있기 때문에 굉장히 편하게 작업할 수 있습니다.

    Buffer 의 장점
        1. I/O 성능 개선 (접근 횟수 감소)
        2. Line 단위 처리 (Enter 한 줄 단위의 처리가 가능해진다)

    Buffer 의 특징
        1. Buffer 는 보조 스트림이기 때문에 독자적으로 사용 불가능합니다.
            BufferedOutPutStream 은 보조 스트림이기 때문에, 독자적인 생산이 불가능합니다.
            따라서 Helper 성 클래스입니다.
            File 을 가지고 노는 주 Stream 들을 도와주는 것이죠.
 */
public class Ex03_Stream_Buffer {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream("data.txt"); //default 경로를 잡게 됨. 여기서 말하는 default 는 소스 파일 위치입니다.
            bos = new BufferedOutputStream(bos); //버퍼 생성 : bos 는 기본 생성자를 만들어 놓지 않고, 주 Stream 을 받도록 설계되어 있습니다.
            for (int i = 0; i < 10; i++) {
                bos.write('A');
                /*
                    data.txt 는 자동으로 생성됩니다.
                    해당 파일에 몇 번 쓰일까요?
                    정답은 현재 상태에서는 한 번도 작성되지 않습니다.

                    buffer 는 몇 인승 버스일까요?

                    서버는 일정한 그릇에 담아서 반복적으로 데이터를 쏴주는데요.
                    웹에는 버퍼가 있습니다.
                    8kb 버퍼가 있죠.
                    이 버퍼는 데이터를 담은 다음에 조건이 있어야 출발하는데요.
                        1. 버퍼는 꽉 차야 한다.
                        2. 꽉 차지 않았다면, flush( ) 를 해주면 보내게 됩니다.

                    왜냐하면 파일에 쓴 것이 아니라 버퍼에 쓴 것이기 때문입니다.
                 */
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fos.close();
                bos.close();
                /*
                    close() 는 flush( ) 가 내장되어 있습니다.
                 */
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

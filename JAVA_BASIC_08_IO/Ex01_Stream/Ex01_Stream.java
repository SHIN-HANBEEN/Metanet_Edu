package Ex01_Stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
    InputStream 과 OutPutStream 은 추상 클래스들입니다.
    당신이 Byte 단위로 받아서 작업을 하려면 Stream 계열을 사용합니다.

    대상이 ...
    1. Memory : ByteArrayInputStream
    2. File   : FileInputStream //이것을 좀 사용할 것이다.

    Byte 단위 데이터 작업을 하려면
    OutputStream 상속 구현하는 클래스를 사용하자

    대상이 ...
    1. Memory : ByteArrayOutputStream
    2. File   : FileOutputStream //이것을 좀 사용할 것이다.
 */
public class Ex01_Stream {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //10개의 방을 갖는 배열 하나
        byte[] outSrc = null; //현재 메모리를 가지고 있지 않아요.
        /*
            byte 는 -127~128 까지 저장가능

            중간 매개체 stream 을 사용해서 Memory 에 있는 데이터를
            read, write 할 수 있습니다.
            기존 Array 를 사용해도 동일한 작업이 가능한데, 지금은 학습이니까요.

            // 입력을 위한 Stream
            ByteArrayInputStream input = null; //입력 전용 Stream 생성!
            // 출력을 위한 Stream
            ByteArrayOutputStream output = null; //출력 전용 Stream 생성!
         */
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc); //데이터를 읽어올 대상을 매개변수로 전달하면, read 할 준비가 끝나게 됨
        output = new ByteArrayOutputStream();

        System.out.println("outSrc before : " + Arrays.toString(outSrc));

        /*
            공식 같은 로직이 하나 있습니다. 거의 암기
            아래 두 식의 차이는 무엇일까요?
            input.read 는 내부적으로 이동하면서 읽어오는데요.
            즉, next 기능을 가지고 있다는 것이죠.
            그래서 변수에 담아서 출력을 해야 합니다.
            그래서 첫 번째 방식으로 출력해야 정상적으로 출력할 수 있습니다.
         */
        int data = 0;
        while ((data = input.read()) != -1) {
//            System.out.println(data);
            /*
                읽은 데이터를 output stream 을 활용해봅시다!
                재밌는 것이 하나 있는데요.
                write 대상이 data 가 아니고 ByteArrayOutputStream 자신의 통로에 write
                하는 것입니다.
                즉, write 를 하면 ouput 내부에 있는 배열에 write 하는 것입니다.
             */
            output.write(data);
            outSrc = output.toByteArray();//힙에 생성된 배열 객체의 주소값을 outSrc 가 가져가게 됩니다.

        }
        System.out.println("outSrc after : " + Arrays.toString(outSrc));
//        while (input.read() != -1) {
//            System.out.println(input.read());
//        }

        /*
            이런 IO 는 log 를 기록할 때 유용하게 사용합니다.
            또한, 파일을 읽고 쓰고 작업할 때 유용하게 사용할 수 있습니다.
         */
    }
}

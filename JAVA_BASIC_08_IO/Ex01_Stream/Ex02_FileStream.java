package Ex01_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    Byte 데이터를 read or write 할 것인데요.
    그 대상이 바로 File 이 되는 것이죠.
    FileInputStream
    FileOutputStream
    주로 자료실을 만들 때, 이미지, 엑셀 같은 것을
    read, write 할 때 사용하면 됩니다.

    특징은, I/O 자원은 GC 가 처리할 수 없습니다.
    그래서, 개발자가 직접 자원을 해제해줘야합니다.
    예를 들어, 내가 워드 파일을 열어놓고 작업 중이라면,
    다른 사람이 그 파일을 read / write 할 수 있게 하려면
    내가 기존 파일을 닫아줘야 하는 것이죠.
    close( ) 가 바로 그런 역할을 해주게 됩니다.

    I/O 에서는 예외 처리가 엄청 많아지게 됩니다.
    자원을 해제하면, 자원을 읽거나 쓸 때 예외가 많기 때문에,
    예외 처리가 강제되어 있습니다. (자바를 설계한 사람이 ... I/O 문제가 많으므로, 강제적
    종료를 막기 위해, try catch 를 쓰도록 강제했습니다)
 */
public class Ex02_FileStream {
    public static void main(String[] args) {
        FileInputStream fs = null;
        FileOutputStream fos = null;

        String path = "C:\\temp\\a.txt";
        try {
            fs = new FileInputStream(path);
            fos = new FileOutputStream("C:\\temp\\new.txt", true);
            /*
                현재 new.txt 파일은 없습니다.
                공식 같은 로직이 하나 더 나옵니다.

                아래 로직에서 File 클래스 생성 한 다음 파일을 생성하고 그 다음 write 를
                해야하는데요.

                FileOutputStream 은 친절하게도
                1. write 할 파일이 존재하지 않으면 File create 를 자동으로 해줍니다.
                2. new FileOutputStream("C:\\temp\\new.txt", false);
                    와 같이 boolean 을 줄 수 있는데요.
                    false 를 주면, 덮어 쓰기를 해줍니다.
                    true 를 주면, 이어 쓰기(append)를 해줍니다.

             */
            int data = 0;
            while ((data = fs.read()) != -1) {
                fos.write(data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            /*
                finally 구문은 매우 강력합니다.
                정상, 비정상 종료가 되어도 실행됩니다.
                강제 실행이라서, 중간에 return 문이 있어도 실행이 됩니다.
                이 finally 구문에서는 close( ) 를 꼭 사용해야 합니다.

                열은 순서대로 fs 먼저 닫고, fos 를 뒤이어 닫아줍니다.
             */
            try {
                fs.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

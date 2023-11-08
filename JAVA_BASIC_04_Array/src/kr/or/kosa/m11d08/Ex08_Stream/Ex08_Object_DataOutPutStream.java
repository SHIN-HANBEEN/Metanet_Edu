package kr.or.kosa.m11d08.Ex08_Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
    파일을 대상으로 객체를 write 할 겁니다.
    객체는 원래 write 가 안 됩니다. 통로가 작기 때문이죠.
 */
public class Ex08_Object_DataOutPutStream {
    public static void main(String[] args) {
        String filename = "UserData.txt";

        FileOutputStream fos = null; //직렬화를 위해서는 Writer 를 쓰지 않고 FileOutPutStream 을 사용합니다.
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);

            //직렬화위한 ObjectOutputStream
            oos = new ObjectOutputStream(bos);

            //객체 생성
            UserInfo u1 = new UserInfo("홍길동", "super", 100); //완제품!
            UserInfo u2 = new UserInfo("scott", "tiger", 50); //완제품!

            oos.writeObject(u1); //객체를 UserData.txt 에 직렬화해서 써줍니다.
            oos.writeObject(u2); //객체를 UserData.txt 에 직렬화해서 써줍니다.
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                fos.close();
                bos.close();
                oos.close();
                System.out.println("파일 생성 >> buffer >> 직렬화 >> 파일 write");
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    /*
        여기서 재밌는 것이 하나 더 있는데요.
        직렬화해서 넣을 때는 보통
        Collection 을 활용해서 넣습니다.
        그러면 Collection 객체 하나만 꺼내면 안에 들어 있는 모든 객체들을 꺼낼 수 있기 때문입니다.
        아주 편리하고, 현업에서 주로 사용하는 방법입니다.
     */
}

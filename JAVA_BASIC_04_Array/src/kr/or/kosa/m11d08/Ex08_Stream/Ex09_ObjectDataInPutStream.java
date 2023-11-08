package kr.or.kosa.m11d08.Ex08_Stream;

import java.io.*;

public class Ex09_ObjectDataInPutStream {
    public static void main(String[] args) {
        String filename = "UserData.txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis);

            UserInfo r1 = (UserInfo) in.readObject(); //readObject 는 Object 타입으로 반환되기 때문에 다운캐스팅해야한다.
            System.out.println(r1.toString());

            UserInfo r2 = (UserInfo) in.readObject(); //readObject 는 Object 타입으로 반환되기 때문에 다운캐스팅해야한다.
            System.out.println(r2.toString());
            /*
                여기에는 문제가 하나 있는데요. 직렬화된 곳에는 구분점이 없기 때문에
                몇 개의 객체가 직렬화 되어 있는 것인지 알 수가 없습니다. 그래서
                아래와 같이 예외 처리르 해주어야 합니다.
             */
            Object users = null;
            while ( ( users = in.readObject() ) != null) {
                System.out.println( ((UserInfo)users).toString() );
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않아요.");
        } catch (EOFException e) {
            System.out.println("끝" + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없어요.");
        } catch (ClassNotFoundException e) {
            System.out.println("해당 객체가 존재하지 않아요.");
        }finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e2) {

            }
        }
    }
}

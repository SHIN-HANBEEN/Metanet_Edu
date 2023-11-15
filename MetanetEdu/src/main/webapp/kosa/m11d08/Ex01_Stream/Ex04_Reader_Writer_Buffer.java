package kr.or.kosa.m11d08.Ex01_Stream;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex04_Reader_Writer_Buffer {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("C:\\temp\\new.txt");
            br = new BufferedReader(fr);

            /*
                Buffer 를 사용하면, 한 줄 씩 읽어서 처리가 가능해집니다.
             */
            String line = "";
            for(int i = 0; (line = br.readLine()) != null; i++) { //br 로 readline 이 null 이 아닐 때 까지 읽습니다.
                //System.out.println(line);
                if(line.indexOf("H") != -1) { // line.indexOf( )!= -1 은 그 라인에 ; 이 있는 데이터만 출력하게 됩니다.
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fr.close();
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

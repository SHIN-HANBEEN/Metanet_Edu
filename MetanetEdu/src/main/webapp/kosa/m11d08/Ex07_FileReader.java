package kr.or.kosa.m11d08;

import java.io.*;

public class Ex07_FileReader {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\temp\\newtest.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ( (s = br.readLine())!=null) {
                System.out.println(s);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

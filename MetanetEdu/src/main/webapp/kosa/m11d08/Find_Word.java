package kr.or.kosa.m11d08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class  PrintWriter_String_Finder {
    String baseDir = "C:\\temp"; //검색할 디렉토리
    String word="HELLO";//검색할 단어
    String savetxt = "result.txt"; //HELLO단어가 들어있는 파일 정보 저장

    void Find() throws IOException { //Find 함수 사용시 try ..예외처리 강제
        File dir = new File(baseDir);
        if(!dir.isDirectory()) {
            System.out.println("유효한 폴더가 아니예요");
            System.exit(0);
        }

        PrintWriter writer = new PrintWriter(new FileWriter(savetxt)); //PrintWriter 는 FileWriter 를 매개변수로 받아갈 수 있다.
        BufferedReader br = null;

        File[] files = dir.listFiles();
        for(int i = 0 ; i < files.length ; i++) {
            if(!files[i].isFile()) { //파일이 아니면 다음을 찾습니다.
                continue; //skip 아래 코드 무시 ...
            }
            //파일이면
            br = new BufferedReader(new FileReader(files[i]));

            //a.txt
            //a.txt 한문장씩 read  (한줄)
            String line="";
            while((line = br.readLine()) != null) {
                //단어검색
                if(line.indexOf(word) != -1) {
                    //a.txt 한줄씩 읽어서 그문장 안에 HELLO 단어가 하나라도 존재하면
                    writer.write("word = " + files[i].getAbsolutePath() +"\n");
                }
            }
            writer.flush();
        }
        br.close();
        writer.close();
    }
}
public class Find_Word {
    public static void main(String[] args) {
        PrintWriter_String_Finder printWriterStringFinder = new PrintWriter_String_Finder();
        try {
            printWriterStringFinder.Find();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
    직렬화 : 완제품을 나눠서 보내기 위한 준비. 즉, 객체를 줄을 세워서 보내는 과정을 의미합니다.
    역직렬화 : 재료를 다시 완제품으로 조립하기. 즉, 직렬화된 자료를 다시 객체로 조립하기.
 */
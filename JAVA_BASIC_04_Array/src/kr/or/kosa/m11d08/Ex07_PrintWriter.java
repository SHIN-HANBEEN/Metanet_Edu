package kr.or.kosa.m11d08;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
    PrintWriter 는 출력 양식을 정해줄 수 있습니다.
    마치 printf 처럼 말이죠.
 */
public class Ex07_PrintWriter {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("C:\\temp\\newtest.txt");
            pw.println("=====================");
            pw.println("========= HOMEWORK ============");
            pw.printf("%3s : %5d, %5d, %5d, %5.1f", "아무개", 100, 80, 90, (100 + 88 + 90) / 3.0f);
            pw.println();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

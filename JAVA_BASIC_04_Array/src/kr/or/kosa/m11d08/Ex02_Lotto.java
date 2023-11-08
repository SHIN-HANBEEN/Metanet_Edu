package kr.or.kosa.m11d08;

/*
1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (중복값 검증)
3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요(정렬 : 자리바꿈 : swap)
4. 위 결과를 담고있는 배열을 출력하세요


별도의 Lotto.java 클래스를 만드시고 ...
클래스 어러우면 main 함수 안에서 ....
*/

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ex02_Lotto {
    public static void main(String[] args) {
        Lotto2 lotto2 = new Lotto2();
        lotto2.Write();
        lotto2.Read();
    }
}
class Lotto2 {
    public void Write() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        int[] lotto = new int[6];
        for(int p = 0; p < 6; p++) { //로또 번호를 총 6번 만들기
            //난수 ...
            //6개의 방 채우기
            for (int i = 0; i < 6; i++) {
                lotto[i] = (int) (Math.random() * 45 + 1);
                for (int j = 0; j < i; j++) {
                    if (lotto[i] == lotto[j]) {
                        i--;
                        break;
                    }
                }
            }
            for (int i = 0; i < lotto.length; i++) {
                for (int j = i + 1; j < lotto.length; j++) {
                    if (lotto[i] > lotto[j]) {
                        int temp = lotto[i];
                        lotto[i] = lotto[j];
                        lotto[j] = temp;
                    }
                }
            }

            //        for(int i = 0 ; i < lotto.length ; i++) {
            //            System.out.print(lotto[i] + "\t");
            //        }

            try {
                fw = new FileWriter("lotto.txt", true);
                bw = new BufferedWriter(fw);

                bw.write(Arrays.toString(lotto) + " " + LocalDateTime.now() + "\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void Read() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("lotto.txt");
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

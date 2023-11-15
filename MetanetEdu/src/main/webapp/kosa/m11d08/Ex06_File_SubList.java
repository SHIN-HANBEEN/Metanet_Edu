package kr.or.kosa.m11d08;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex06_File_SubList {
    static int totalfiles = 0;
    static int totaldir = 0;

    static void printFileList(File dir) {
        System.out.println("Full Path : " + dir.getAbsolutePath());
        List<Integer> subdir = new ArrayList<>();
        File[] files = dir.listFiles();//하위 폴더와 파일들을 포함하고 있는 listFiles()

        for (int i = 0; i < files.length; i++) {
            String filename = files[i].getName(); //filename 은 폴더명 or 파일명
            if (files[i].isDirectory()) {
                filename = " [ DIR ]" + filename;
                subdir.add(i);
            } else {
                filename = filename + " / " + files[i].length() + "byte"; //file 은 byte[] 이므로 length 는 byte 의 크기가 된다.
            }
        }

        //폴더 개수
        int dirnum = subdir.size(); //subdir 는 List 의 동적 배열이므로 size 를 이용!
        //파일 개수
        int filenum = files.length - dirnum; //filenum 은 전체 개수에서 - 폴더 개수 해주면 된다.

        //누적 개수
        totaldir += dirnum;
        totalfiles += filenum;

        System.out.println("[Current Dirnum] : " + dirnum);
        System.out.println("[Current Filenum] : " + filenum);

        /*
            그런데, 하위 폴더의 하위 폴더와 하위 파일들은 어떻게 파악하지??
         */
        System.out.println("==============");
        //List<Integer> subdir = new ArrayList<>();
        //subdir.add(i); 했으므로, subdir.get(i) 는 방 번호를 반환시켜줍니다.
        for (int i = 0; i < subdir.size(); i++) {
            int index = subdir.get(i);
            printFileList(files[index]); //재귀 처럼 다시 호출한다.
        }
    }

    public static void main(String[] args) {
        File f = new File("C:\\temp");
        if(!f.exists() || !f.isDirectory()) {
            System.out.println("유효한 디렉토리가 아닙니다");
            System.exit(0);
        }
        /*
            위의 제어문을 통과하면, 정상적인 경로이고, 폴더임을 확신할 수 있다.
         */
        printFileList(f);
        System.out.println("누적 총 파일 수 : " + totalfiles);
        System.out.println("누적 총 폴더 수 : " + totaldir);
    }
}

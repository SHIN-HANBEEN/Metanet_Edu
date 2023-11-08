package kr.or.kosa.m11d08;

import java.io.File;

/*
    자바에서는 파일, 폴더를 나눠서 다루지 않습니다.
    C# 에서는 File, Directory 를 나누지만,
    Java 에서는 File 로 다룹니다.

    Java : File (파일생성, 삭제, ... 폴더 생성, 삭제)

 */
public class Ex05_File_Dir {
    public static void main(String[] args) {
        File f = new File("C:\\temp");
        /*
            File 클래스를 주로 쓰는 이유는, 다양한 정보를 얻을 수 있기 때문입니다.

         */
        if(!f.exists() || !f.isDirectory()) { //존재하지 않거나, 디렉터리가 아니면
            System.out.println("유효하지 않은 경로입니다.");
            System.exit(0); //프로세스의 강제 종료입니다.
        }
        /*
            실제 존재하는 경로이고, 폴더라면
            POINT 는...
                f.listFiles( ) 를 정말 많이 씁니다.
                f.listFiles( ) 는 File[] 를 반환합니다.
                예를 들어서, File[] : [1.txt][2.jpg][3.img][디렉터리1][디렉터리2]...
                이런 식으로 반환된다는 것이죠.
         */
        File[] files = f.listFiles();
        for(int i = 0; i < files.length; i++) {
            String name = files[i].getName(); //files[i] 은 파일 혹은 디렉터리일 수 있습니다. 그래서 제어문을 사용해야해요.
            System.out.println(files[i].isDirectory() ? "[DIR]" + name : name); //이렇게 디렉터리임을 명시할 수 있는 것이죠.
        }
    }
}

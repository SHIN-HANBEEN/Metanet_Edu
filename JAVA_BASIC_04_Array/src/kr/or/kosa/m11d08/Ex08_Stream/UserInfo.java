package kr.or.kosa.m11d08.Ex08_Stream;

import java.io.Serializable;

/*
    객체 통신
        객체(Car, Tv, Tank) >> 프로세스, 네트워크, 파일 간의 통신 >>
        통신을 위해서 직렬화 , 다시 역직렬화

    직렬화
        객체를 분해해서 줄을 세워 보내는 과정

    역직렬화
        객체를 다시 조립하는 과정

    모든 자원(class) 직렬화 과정 >> 아니요
    직렬화 가능한 제품 설계 (레고블럭)

    단, 직렬화 하기 위해서는 Serializable 을 사용해야 합니다.

    ===============
    지금 하려는 것은 파일에 객체를 직렬화해서 write ...
    파일을 read 역직렬화 합니다.
    객체를 통신하는 것은 엄청나게 편리합니다. (물론, DB가 있을 때는 DB로 하지만요)
 */
public class UserInfo implements Serializable {
    private String name;
    private String pwd;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserInfo(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }
}

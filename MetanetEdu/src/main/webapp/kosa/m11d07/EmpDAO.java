package kr.or.kosa.m11d07;

import java.util.List;
import java.util.Map;

/*
    MVC (
        Model   ( DTO(DB담는객체), DAO(DB 연결&명령 : CRUD) ) : 나머지 뒷 단 처리
        View    ( HTML, JSP, Thymeleaf ) : 앞 단 처리
        Controller  (servlet) : 통제 역할
        )

    MVC 는 각자 잘하는 것을 해! 라는 개념입니다.
    POJO ( Plain Old Java Object ) 클래스!
    Model 은 Java 가 잘 합니다.
    View 는 Java 가 잘 못해서, HTML & JSP & Thymeleaf 가 잘 합니다.
    Controller 은 Servlet(외부에서 사용할 수 있는 Java 파일)이 잘 합니다.
        Java 는 클라이언트의 요청과 응답을 잘 하지 못해요.
        그래서 Servlet 파일은 Java 파일인데, Web 의 요청을 받거나 응답을
        할 수 있는 파일을 의미합니다.
        Servlet 은 화면에 뿌리기가 너무 힘든데요. 그래서 나온 것이 JSP 입니다.
        Controller 는 조정의 역할입니다. 즉, 클라이언트의 요청을 Servlet 이
        받아주는 것이죠.
 */
public class EmpDAO {
    /*
        DAO (CRUD) 를 만든다는 것은
        함수 5개를 만드는 것이다.
            전체조회
            조건조회
            삽입
            수정
            삭제
            조회(검색)
     */
    public List<Emp> getEmpAllList() {
        //select empno, ename, job from emp;
        return null;
    }
    public Emp getEmpListByEmpno(int empno) {
        //select empno, ename, job from emp where empno = 778
        return null;
    }
    /*
        Map map = new HashMap();
        map.put("title", "자바과정");
     */
    public List<Emp> getEmpFindBySearchCondition(Map<String, String> search) {
        return null;
    }
}

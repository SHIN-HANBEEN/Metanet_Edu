package com;

import java.io.IOException;
import java.util.Date;
import java.util.zip.DataFormatException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
1. SimpleController extends HttpServlet 
>> SimpleController  HttpServlet 파일을 상속하고 있어요 
>> SimpleController.java >> 웹에 사용되는 객체를 사용가능 >> 일반 자바파일이 아니라 웹용 자바파일(서블릿) 이라 하자

>> HttpServletRequest request = new HttpServletRequest();
>> 객체가 자동 생성 .... request 객체를 가지고 놀 수 있어요

>> HttpServletResponse response = new HttpServletResponse();
>> 객체가 자동 생성 .... response 객체를 가지고 놀 수 있어요

jsp 파일
주소창에 : http://..../default.jsp

servlet
주소창에 : http://..../SimpleController.java ...(x)

web.xml 파일에서 요청 주소를 설정
[어떤 요청 주소가] 들어오면 SimpleController 컴파일 하고 실행할 거냐 ..정의

web.xml
에서
	<servlet-name>simplecontroller</servlet-name>
  	<url-pattern>/simple</url-pattern>
  	
  	1. http://localhost:8090/WebServlet_1/simple  요청이 오면
  	2. <servlet-name>simplecontroller</servlet-name>
  	   <servlet-class>com.SimpleController</servlet-class>  설정의 근거로 
  	   com.SimpleController.java  컴파일하고 실행 합니다..
  	3. 다음 똑같은 요청 들어오면  실행파일 있으면 실행 합니다...
  	
서블릿 조건: 일반 java 파일이 extends HttpServlet 상속 >> 웹 요청(request) , 웹 응답(response) 객체 사ㅛㅇ
-servlet url 요청 바로 할 수 없어요 >> 요청 >> mapping >> xml or annotation

1. web.xml (구방식)
2. @WebServlet (현재 ..) 	  ex) @WebServlet("/simple")  매핑



protected void doGet() 함수
ex) http://localhost:8090/WebServlet_1/simple   GET방식 

protected void doPost() 함수
ex) http://localhost:8090/WebServlet_1/simple   (form 만들고 method=post 지정)
명시적인 호출에 의해서 동작 ..... 일반적인 ....

2개의 함수는 어떤 사건이 발생하는 자동 호출 되도록

EX) Javascript 이벤트 ... 자동 함수 호출 (onload... 사건이 발생하면 핸들러 함수 자동 호출)  

doGET() , doPOST() 
1. request 객체 , response 객체를 가지고 데이터 처리 (받고) , 응답하고 ....
*/
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleController() {
        super();
		System.out.println("SimpleController 생성자 함수 실행 : 초기화");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("클라이언트 요청 GET");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");

		//2. 데이터 받기
		String type = request.getParameter("type");

		//3. 업무수행(회원가입, 게시판 글쓰기, 로그아웃) 비즈니스 파악
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj="hello world";
		} else if (type.equals("date")) {
			resultobj = new Date();
		} else {
			resultobj = "invalid String type";
		}

		//3.1 암호화 작업


		//4. 데이터 저장 (view 단까지 전달을 위해서)
		request.setAttribute("result", resultobj);

		//4.1 request, session
		// 모든 페이지에서 공유할 것이냐, 현재 페이지 또는 include 또는 forward 에서만
		// 쓸 것인가에 따라서 session 과 request 를 선택하면 됩니다.


		//5. view 구성 (어디 있는지 찾아서 전달할 준비)
		//UI 구성 : webapp > simpleview.jsp --> 이렇게 만드는 건 권장하지 않는다.
		// 왜냐하면 클라이언트가 다이렉트로 해당 경로로 접근할 수 있기 때문이다.
		// 그래서 WEB-INF > Views > board > SimpleView.jsp 이런 식으로 구성한다.
		// WEB-INF 에 넣어야 보안상 적합하다.
		// View 를 찾는 방법은 requestDispatcher 입니다.
		// Spring 가면 Controller 를 제공해주는데요. 지금은 직접 만들어 보는 겁니다.
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp"); //webapp 폴더 밑에 생성하기

		//6. view 에게 내가 가지고 있는 데이터 전달 (forward 방식으로 전달)
		// forward 를 해줘야 한다.
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}

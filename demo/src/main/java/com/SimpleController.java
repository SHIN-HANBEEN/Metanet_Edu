package com;

import java.io.IOException;
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
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}

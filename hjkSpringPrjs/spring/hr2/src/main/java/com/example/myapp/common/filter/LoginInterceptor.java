package com.example.myapp.common.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			String email= (String) request.getSession().getAttribute("email");
			if(email == null || email.equals("")){
				response.sendRedirect(request.getContextPath()+"/member/login");
				return false;//핸들러를 통과하지 못하면, 다른 핸들러를 통과할 필요가 없기 때문에 false
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
package com.example.myapp.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

/*
 * JwtAuthenticationFilter 는 GenenricFilterBean 을 상속받아서 구현을 합니다.
 * JwtAuthenticationFilter 는 요청으로 들어온 Token 을 읽어서 유효한지 확인하고, 
 * 유효하다면 Spring SecurityContext 에 Authentication 객체를 넣는 작업을 여기서 해주어야 합니다. 
 * 
 * SecurityConfig 에서 빈으로 등록해서 사용할 것이기 때문에 어노테이션은 필요 없습니다.
 * 다만, @AllArgsConstructor 를 해두어야 JwtTokenProvider 를 생성자를 만들기 위한
 * 의존성 설정을 진행하게 됩니다.
 * SecurityConfig 파일에 가보면 단번에 이해할 수 있습니다.
 */
@AllArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean{

	/*
	 * JwtTokenProvider 에 doFilter 에서 필요한 작업들을 
	 * 만들어 놓으면, 여기서는 간단하게 꺼내서 사용을 하기만 하면 되겠습니다. 
	 * 
	 * SecurityConfig 에서 JwtAuthenticationFilter를
	 *  빈으로 등록해서 사용할 것이기 때문에 어노테이션은 필요 없습니다.
	 */
	JwtTokenProvider jwtTokenProvider;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 토큰을 읽기
		 * 우리는 요청 헤더에서 읽어올 거에요.
		 * 
		 * HttpServletRequest 형태로 형변환한 req 를 이용해서 작업을 처리할 겁니다.
		 * 
		 * jwtTokenProvider 에서 구현한 request에서 token 을 꺼내오는 resolveToken 을 이용합니다.
		 */
		HttpServletRequest req = (HttpServletRequest)request;
		String token = jwtTokenProvider.resolveToken(req);
		
		/*
		 * 토큰이 유효한지 확인하기
		 * 토큰이 유효한지 확인을 해야 합니다.
		 * jwtTokenProvider 의 validToken()을 이용하면 됩니다.
		 */
		if(token!=null && jwtTokenProvider.validateToken(token)) {
			/*
			 * 토큰에서 사용자 정보를 빼내서 Authentication 객체를 만들기
			 * 토큰이 유효하다면, Authentication 객체를 만들어서
			 * SecurityContext 에 넣어주어야 합니다.
			 * jwtTokenProvider 의 getAuthentication 으로 auth 를 가져옵니다.
			 */
			Authentication auth = jwtTokenProvider.getAuthetication(token);
			
			/*
			 * Authentication 객체를 SecurityContext 에 넣어주기(set해주기)
			 * SecurityContextHolder 로부터 Context 를 가져온 다음
			 * SecurityContext 안에 Authentication 을 넣어주면 됩니다.
			 */
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(auth);
		}
		
		/*
		 * doFilter 전에 토큰 인증과 SecurityContext 에 
		 * 담는 작업을 마쳐 둡니다.
		 */
		chain.doFilter(request, response);
	}

}

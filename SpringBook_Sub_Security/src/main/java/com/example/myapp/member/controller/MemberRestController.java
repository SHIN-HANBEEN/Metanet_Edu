package com.example.myapp.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.jwt.JwtTokenProvider;
import com.example.myapp.member.model.Member;
import com.example.myapp.member.service.IMemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberRestController {
	
	@Autowired
	IMemberService memberService;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	/*
	 * 평문으로 들어오는 비밀번호를 DB와 비교하기 위해서 사용
	 */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> user) {
		log.info(user.toString());
		/*
		 * web 에서 보낸 데이터에서 "userid" 키 값을 꺼내서 그걸로 
		 * Member 객체를 얻어내고, 
		 * 유효성 검사를 마친 후에는 token 을 만들어서 반환해주면 된다.
		 */
		Member member = memberService.selectMember(user.get("userid"));
		if (member==null) {
			throw new IllegalArgumentException("사용자가 없습니다");
		} 
		if(!passwordEncoder.matches(user.get("password"), member.getPassword())) {
			throw new IllegalArgumentException("비밀번호 오류");
		}
			
		return tokenProvider.generateToken(member);
	}
	
	@GetMapping("/test_jwt")
	public String testJwt(HttpServletRequest request) {
		String token = tokenProvider.resolveToken(request);
		log.info("token {}", token); //더 빨라서 + 쓰는 것 보다 권장됩니다 String Builder 를 사용하거든요.
		Authentication auth = tokenProvider.getAuthetication(token);
		log.info("principal {}, name {}, authorities {}", auth.getPrincipal(), auth.getName(), auth.getAuthorities());
		log.info("isValid {}", tokenProvider.validateToken(token));
		return tokenProvider.getUserId(token);
	}
	
}












































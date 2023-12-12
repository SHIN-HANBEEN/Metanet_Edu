package com.example.myapp.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.myapp.member.service.IMemberService;

@Component
public class MemberUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IMemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member memberInfo = memberService.selectMember(username);
		if(memberInfo == null) { //로그인하지 않은 사용자
			throw new UsernameNotFoundException("[" + username + "] 사용자는 없습니다."); 
			//SpringSecurity 가 갖는 예외 발생 with 메시지
		}
		
		String[] roles = {"ROLE_USER", "ROLE_ADMIN"}; //DB에는 ROLE_ 로 저장을 해야해서, 이렇게 작성
		// 위의 권한을 활용해서 authorities 를 만들어야 합니다. 
		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles); 
		//String 배열을 활용해서 Authority 배열을 만들 수 있는 AuthorityUtils 의 createAuthorityList 메서드
		
//		return new User(memberInfo.getUserid(), "{noop}" + memberInfo.getPassword(), authorities);
		// 위에서 비밀번호는 일단, 평문으로 가져왔으니 {noop} 으로 알려줘야합니다.
		
		// 만일 기본 정보 말고, 다른 컬럼을 포함해서 반환하려면 아래와 같이 User 구현한 객체 반환
		return new MemberUserDetails(memberInfo.getUserid(),
				"{noop}" + memberInfo.getPassword(),
				authorities,
				memberInfo.getEmail());
	}

}

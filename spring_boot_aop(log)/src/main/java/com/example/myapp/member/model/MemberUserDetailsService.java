package com.example.myapp.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
		if(memberInfo==null) {
			throw new UsernameNotFoundException("["+username+"]사용자 없어요");
		}
		String[] roles = {"ROLE_USER", "ROLE_ADMIN"}; // 데이터베이스에 조회했다고 가정
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
		
//		return new User(memberInfo.getUserid(), "{noop}"+memberInfo.getPassword(), authorities);
		return new MemberUserDetails(memberInfo.getUserid(), memberInfo.getPassword(), 
				authorities, memberInfo.getEmail());
	}

}

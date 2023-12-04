package com.sample.myapp.member;

public class MemberService implements IMemberService {
	IMemberRepository memberRepository;
	
	@Override
	public MemberVO getMemberInfo() {
		// TODO Auto-generated method stub
		return memberRepository.getMemberInfo();
	}

	public void setMemberRepository(IMemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
}

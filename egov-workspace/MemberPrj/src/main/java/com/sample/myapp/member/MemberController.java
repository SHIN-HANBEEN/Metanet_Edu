package com.sample.myapp.member;

public class MemberController {
	MemberService memberService;
	
	public void printInfo() {
		MemberVO vo = memberService.getMemberInfo();
		System.out.println(vo);
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
}

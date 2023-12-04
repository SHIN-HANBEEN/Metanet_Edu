package com.sample.myapp.member;

public class MemberRepository implements IMemberRepository{

	@Override
	public MemberVO getMemberInfo() {
		MemberVO vo = new MemberVO();
		vo.setAge(10);
		vo.setEmail("email1");
		vo.setMemberID("1234");
		vo.setName("name1");
		return vo;
	}

}

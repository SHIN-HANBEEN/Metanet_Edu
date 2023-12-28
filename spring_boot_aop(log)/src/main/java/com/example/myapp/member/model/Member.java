package com.example.myapp.member.model;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Member {
	
	@Pattern(regexp="[A-Z]{5,}", message="아이디는 대문자 5자 이상")
    private String userid;
	
    private String name;
    private String password;
    private String password2;
    private String phone;
    private String email;
    private String role;
}
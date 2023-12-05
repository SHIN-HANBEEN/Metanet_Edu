package com.example.myapp.kosa;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class EmpVO {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptNo;
}

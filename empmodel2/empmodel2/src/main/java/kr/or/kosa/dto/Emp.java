package kr.or.kosa.dto;

import lombok.Data;

import java.sql.Date;


@Data
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;
}

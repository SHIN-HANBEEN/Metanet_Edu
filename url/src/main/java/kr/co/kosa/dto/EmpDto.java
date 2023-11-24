package kr.co.kosa.dto;

import java.util.Date;
import java.util.Optional;

public class EmpDto {
 private int EMPNO;
 private String ENAME;
 private String JOB;
 private int MGR;
 private Date HIREDATE;
 private int SAL;
 private int COMM;
 private int DEPTNO;
public int getEMPNO() {
	return EMPNO;
}
public void setEMPNO(int eMPNO) {
	EMPNO = eMPNO;
}
public String getENAME() {
	return ENAME;
}
public void setENAME(String eNAME) {
	ENAME = eNAME;
}
public String getJOB() {
	return JOB;
}
public void setJOB(String jOB) {
	JOB = jOB;
}
public int getMGR() {
	return MGR;
}
public void setMGR(int mGR) {
	MGR = mGR;
}
public Date getHIREDATE() {
	 return Optional.ofNullable(this.HIREDATE).orElse(new Date());
}
public void setHITRDATE(Date hIREDATE) {
	HIREDATE = hIREDATE;
}
public int getSAL() {
	return SAL;
}
public void setSAL(int sAL) {
	SAL = sAL;
}
public int getCOMM() {
	return COMM;
}
public void setCOMM(int cOMM) {
	COMM = cOMM;
}
public int getDEPTNO() {
	return DEPTNO;
}
public void setDEPTNO(int dEPTNO) {
	DEPTNO = dEPTNO;
}



}

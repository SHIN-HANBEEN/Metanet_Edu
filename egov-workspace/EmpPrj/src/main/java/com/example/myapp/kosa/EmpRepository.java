package com.example.myapp.kosa;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	
	//Spring JDBC 가 제공해주는 클래스에 대한 의존성 주입을 어떻게 해줘야할까? Bean 으로 만들어줘야하고, DataSource
	//도 만들어줘야하는데요. 이것은 xml 문서에 추가를 해줘야합니다.
	@Autowired
	JdbcTemplate jdbcTemplate; //jdbc 연결을 위해서 jdbcTemplate 이 필요합니다. 
	
	@Override
	public int getEmpCount(int deptid) {
		String sql = "select count(*) from emp where deptno=?";
		
		return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
	}

	
	@Override
	public String getEmpNameByEmployeeId(int empNo) {
		String sql = "select ename from emp where empNo=?";
		
		return jdbcTemplate.queryForObject(sql, String.class, empNo);
	}


	@Override
	public EmpVO getEmp(int empno) {
		String sql = "select * from emp where empno=?"; //*는 원래 사용하면 안된다. 회사에서 컬럼 추가하는 일이 잦은데, 이렇게 작성하면 프로그램이 죽어버리는 경우가 생긴다.
		
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empno);
	}
	
	
	private class EmpMapper implements RowMapper<EmpVO> {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmpNo(rs.getInt("empno"));
			emp.setEName(rs.getString("ename"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setHireDate(rs.getDate("hiredate"));
			emp.setSal(rs.getInt("sal"));
			emp.setComm(rs.getInt("comm"));
			emp.setDeptNo(rs.getInt("deptNo"));
			return emp;
		}
	}


	@Override
	public List<EmpVO> getAllEmps() {
		String sql = "select * from emp";
		return jdbcTemplate.query(sql, new EmpMapper());
	}
	
}



























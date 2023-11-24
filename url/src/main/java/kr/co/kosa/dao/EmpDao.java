package kr.co.kosa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import kr.co.kosa.dto.EmpDto;
import kr.co.kosa.utils.ConnectionHelper;

public class EmpDao {

	public int readOk(EmpDto dto) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int result = 0;

	    try {
	        conn = ConnectionHelper.getConnection("oracle");
	        String sql = "insert into mvcregister(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)";
	        pstmt = conn.prepareStatement(sql);

	        // Set values for the parameters
	        pstmt.setInt(1, dto.getEMPNO());
	        pstmt.setString(2, dto.getENAME());
	        pstmt.setString(3, dto.getJOB());
	        pstmt.setInt(4, dto.getMGR());
	        pstmt.setDate(5, new java.sql.Date(dto.getHIREDATE().getTime()));
	        pstmt.setInt(6, dto.getSAL());
	        pstmt.setInt(7, dto.getCOMM());
	        pstmt.setInt(8, dto.getDEPTNO());

	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        ConnectionHelper.close(pstmt);
	        ConnectionHelper.close(conn);
	    }

	    return result;
	}
	 public List<EmpDto> getEmpDataByName(String name) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        List<EmpDto> empList = new ArrayList<>();

	        try {
	            conn = ConnectionHelper.getConnection("oracle");
	            String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp WHERE ename LIKE ?";
	            
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + name + "%"); // Using LIKE for partial name matching
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                EmpDto empDto = new EmpDto();
	                empDto.setEMPNO(rs.getInt("empno"));
	                empDto.setENAME(rs.getString("ename"));
	                empDto.setJOB(rs.getString("job"));
	                empDto.setMGR(rs.getInt("mgr"));
	                empDto.setHITRDATE(rs.getDate("hiredate"));
	                empDto.setSAL(rs.getInt("sal"));
	                empDto.setCOMM(rs.getInt("comm"));
	                empDto.setDEPTNO(rs.getInt("deptno"));

	                empList.add(empDto);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());

	        } finally {
	            ConnectionHelper.close(rs);
	            ConnectionHelper.close(pstmt);
	            ConnectionHelper.close(conn);
	        }

	        return empList;
	    }
	 
	 public int createEmp(EmpDto dto) {
		    int result = 0;

		    try (Connection conn = ConnectionHelper.getConnection("oracle");
		         PreparedStatement pstmt = conn.prepareStatement(
		                 "INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)"
		         )) {

		        pstmt.setInt(1, dto.getEMPNO());
		        pstmt.setString(2, dto.getENAME());
		        pstmt.setString(3, dto.getJOB());
		        pstmt.setInt(4, dto.getMGR());
		        pstmt.setDate(5, new java.sql.Date(dto.getHIREDATE().getTime()));
		        pstmt.setInt(6, dto.getSAL());
		        pstmt.setInt(7, dto.getCOMM());
		        pstmt.setInt(8, dto.getDEPTNO());

		        // Log the SQL query
		        System.out.println("SQL Query: " + pstmt.toString());

		        result = pstmt.executeUpdate();


		    } catch (SQLException e) {
		        // Log the exception details or rethrow a custom exception
		        e.printStackTrace();
		    }

		    return result;
		}





	 
	 public int updateEmp(EmpDto dto) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        int result = 0;

	        try {
	            conn = ConnectionHelper.getConnection("oracle");
	            String sql = "UPDATE emp SET ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno=?";
	            pstmt = conn.prepareStatement(sql);

	            pstmt.setString(1, dto.getENAME());
	            pstmt.setString(2, dto.getJOB());
	            pstmt.setInt(3, dto.getMGR());
	            if (dto.getHIREDATE() != null) {
	                pstmt.setDate(4, new java.sql.Date(dto.getHIREDATE().getTime()));
	            } else {
	                pstmt.setNull(4, java.sql.Types.DATE);
	            }

	            pstmt.setInt(5, dto.getSAL());
	            pstmt.setInt(6, dto.getCOMM());
	            pstmt.setInt(7, dto.getDEPTNO());
	            pstmt.setInt(8, dto.getEMPNO());

	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            ConnectionHelper.close(pstmt);
	            ConnectionHelper.close(conn);
	        }

	        return result;
	    }

	    public int deleteEmp(int empno) { //삭제
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        int result = 0;

	        try {
	            conn = ConnectionHelper.getConnection("oracle");
	            String sql = "DELETE FROM emp WHERE empno=?";
	            pstmt = conn.prepareStatement(sql);

	            pstmt.setInt(1, empno);

	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            ConnectionHelper.close(pstmt);
	            ConnectionHelper.close(conn);
	        }

	        return result;
	    }
	 
	
    public List<EmpDto> getAllEmpData() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<EmpDto> empList = new ArrayList<>();

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                EmpDto empDto = new EmpDto();
                empDto.setEMPNO(rs.getInt("empno"));
                empDto.setENAME(rs.getString("ename"));
                empDto.setJOB(rs.getString("job"));
                empDto.setMGR(rs.getInt("mgr"));
                empDto.setHITRDATE(rs.getDate("hiredate"));
                empDto.setSAL(rs.getInt("sal"));
                empDto.setCOMM(rs.getInt("comm"));
                empDto.setDEPTNO(rs.getInt("deptno"));

                empList.add(empDto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

        return empList;
    }
}

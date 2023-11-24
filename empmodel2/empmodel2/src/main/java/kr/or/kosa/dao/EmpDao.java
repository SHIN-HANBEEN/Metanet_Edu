package kr.or.kosa.dao;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    public Emp findEmpByName(String ename) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Emp emp = new Emp();

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql="select * from emp where ename like ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "%" + ename + "%");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getInt("sal"));
                emp.setComm(rs.getInt("comm"));
                emp.setDeptno(rs.getInt("deptno"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
        return emp;
    }

    public Emp findEmpByEmpNo(int empno){
        Connection conn = null;
        PreparedStatement pstmt = null;
        Emp emp = null;

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql="select * from emp where empno = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, empno);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getInt("sal"));
                emp.setComm(rs.getInt("comm"));
                emp.setDeptno(rs.getInt("deptno"));
            }
            System.out.println(emp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
        return emp;
    }

    public List<Emp> findAllEmp() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Emp> list = new ArrayList<>();

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql="select * from emp";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getInt("sal"));
                emp.setComm(rs.getInt("comm"));
                emp.setDeptno(rs.getInt("deptno"));

                list.add(emp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
        return list;
    }

    public void addEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,emp.getEmpno());
            pstmt.setString(2, emp.getEname());
            pstmt.setString(3, emp.getJob());
            pstmt.setInt(4, emp.getMgr());
            pstmt.setDate(5, emp.getHiredate());
            pstmt.setInt(6, emp.getSal());
            pstmt.setInt(7, emp.getComm());
            pstmt.setInt(8, emp.getDeptno());
            pstmt.executeUpdate();

            System.out.println("추가완료");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
    }

    public void updateEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emp.getEname());
            pstmt.setString(2, emp.getJob());
            pstmt.setInt(3, emp.getMgr());
            pstmt.setDate(4, emp.getHiredate());
            pstmt.setInt(5, emp.getSal());
            pstmt.setInt(6, emp.getComm());
            pstmt.setInt(7, emp.getDeptno());
            pstmt.setInt(8, emp.getEmpno());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
    }

    public void deleteEmp(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "delete from emp where empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empno);

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn); //반환
        }
    }
}

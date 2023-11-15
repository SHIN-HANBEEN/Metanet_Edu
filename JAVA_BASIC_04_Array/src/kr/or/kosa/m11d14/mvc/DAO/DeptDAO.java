package kr.or.kosa.m11d14.mvc.DAO;

import kr.or.kosa.m11d14.mvc.DTO.DeptDto;
import kr.or.kosa.m11d14.mvc.utils.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    CRUD 함수를 만드세요
    추가사항 (LIKE 사용해서,,, 부서 이름 검색 하는 함수 추가)
    1.  전체조회
    2.  조건조회
    3.
 */
public class DeptDAO {
    public boolean insert(DeptDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int flag = 0;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "insert into dept values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getDeptNo());
            pstmt.setString(2, dto.getdName());
            pstmt.setString(3, dto.getLoc());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        if (flag > 0) {
            //성공
            return true;
        } else {
            //실패
            return false;
        }
    }

    public boolean update(DeptDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int flag = 0;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "update deptno set deptno=?, dname=?, loc=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getDeptNo());
            pstmt.setString(2, dto.getdName());
            pstmt.setString(3, dto.getLoc());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        if (flag > 0) {
            //성공
            return true;
        } else {
            //실패
            return false;
        }
    }

    public boolean delete(DeptDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int flag = 0;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "delete from dept where deptno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getDeptNo());
            //sql 문 실행하기 (INSERT, UPDATE, DELETE)
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        if (flag > 0) {
            //성공
            return true;
        } else {
            //실패
            return false;
        }
    }

    public DeptDto getData(int deptno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DeptDto dto = null;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "select * from dept where deptno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            //select 문 수행하고 결과를 ResultSet 으로 받아오기
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new DeptDto();
                dto.setDeptNo(deptno);
                dto.setdName(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return dto;
    }

    public List<DeptDto> getList() {
        //필요한 객체를 담을 지역 변수 미리 만들기
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DeptDto> list = new ArrayList<>();

        try {
            //Connection 객체의 참조값 얻어오기
            conn = ConnectionHelper.getConnection("oracle");
            //실행할 sql 문의 뼈대 미리 준비하기
            String sql = "select * from dept";
            //PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //select 문 수행하고 결과를 ResultSet 으로 받아오기
            rs = pstmt.executeQuery();
            while (rs.next()) {
                DeptDto dto = new DeptDto();
                dto.setDeptNo(rs.getInt("deptno"));
                dto.setdName(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }

    public DeptDto getByDNameLike(String DNameLike) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DeptDto dto = null;
        try {
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "select * from dept where dname like ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, DNameLike);
            //select 문 수행하고 결과를 ResultSet 으로 받아오기
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new DeptDto();
                dto.setDeptNo(rs.getInt("deptno"));
                dto.setdName(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return dto;
    }
}

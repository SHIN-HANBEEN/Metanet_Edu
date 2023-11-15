package kr.or.kosa.m11d14.mvc;

import kr.or.kosa.m11d14.mvc.DAO.DeptDAO;
import kr.or.kosa.m11d14.mvc.DTO.DeptDto;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        /*
            Controller ... View 담당
            1.  부서 테이블 데이터 전체 조회 화면 출력
            2.  부서번호로 조건 조회 1건의 부서 정보 화면 출력
            3.  데이터 삽입 (1건) (50, 'IT', 'SEOUL')
            3.1 전체 조회 다시
            4.  방금전 삽입 했던 데이터 수정
            4.1 부서이름 ('IT_UP', 'BUSAN')
            4.2 전체 조회 다시
            5.  방금전 업데이트했던 데이터 삭제
            5.1 50번 데이터 삭제
            5.2 다시 전체 조회
         */
        DeptDAO deptDAO = new DeptDAO();
        DeptDto deptDto = new DeptDto();

        System.out.println(Arrays.toString(new List[]{deptDAO.getList()}));
        System.out.println(deptDAO.getData(20));
        System.out.println(deptDAO.getByDNameLike("%T%")); //Like 검색
        deptDto.setDeptNo(50);
        deptDto.setdName("IT");
        deptDto.setLoc("SEOUL");
        deptDAO.insert(deptDto);
        System.out.println(Arrays.toString(new List[]{deptDAO.getList()})); // 전체 다시 조회
        System.out.println(Arrays.toString(new List[]{deptDAO.getList()})); // 전체 다시 조회
        deptDAO.delete(deptDto); //삭제
        System.out.println(Arrays.toString(new List[]{deptDAO.getList()})); // 전체 다시 조회
    }
}

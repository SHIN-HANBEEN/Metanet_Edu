package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dto.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Board_listServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        BoardService service = BoardService.getInBoardService();
        ActionForward forward = new ActionForward();

        //게시물 총 건수
        int totalboardcount = 0;
        try {
            totalboardcount = service.totalBoardCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //상세보기 >> 다시  LIST 넘어올때  >> 현재 페이지 설정
        String ps = request.getParameter("ps"); //pagesize
        String cp = request.getParameter("cp"); //current page

        //List 페이지 처음 호출 ...
        if(ps == null || ps.trim().equals("")){
            //default 값 설정
            ps = "5"; //5개씩
        }

        if(cp == null || cp.trim().equals("")){
            //default 값 설정
            cp = "1"; // 1번째 페이지 보겠다
        }

        int pagesize = Integer.parseInt(ps);
        int cpage = Integer.parseInt(cp);
        int pagecount=0;

        //23건  % 5
        if(totalboardcount % pagesize == 0){
            pagecount = totalboardcount / pagesize; //  20 << 100/5
        }else{
            pagecount = (totalboardcount / pagesize) + 1;
        }

        //102건 : pagesize=5 >> pagecount=21페이지

        //전체 목록 가져오기
        List<Board> list = null;
        try {
            list = service.list(cpage, pagesize); //list >> 1 , 20
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("list",list); //list 로 담아서 board_list.jsp 에 전달함
        System.out.println(list);
        request.setAttribute("pagesize", pagesize); //pagesize 도 같이 전달
        request.setAttribute("cpage", cpage); //cpage 도 같이 전달
        request.setAttribute("pagecount", pagecount); //pagecount 도 같이 전달
        request.setAttribute("totalboardcount", totalboardcount); //totalboardcount 도 같이 전달

        forward.setPath("/board/board_list.jsp");

        return forward;
    }
}

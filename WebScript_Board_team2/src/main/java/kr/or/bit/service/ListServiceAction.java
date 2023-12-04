package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.utils.ThePager;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
        System.out.println("listServiceAction execute");
		ActionForward forward = new ActionForward();
        //DAO BoardService 는 그냥 DAO임
        BoardService service = BoardService.getInBoardService();

        //게시물 총 건수
        int totalboardcount = 0;
        try {
            totalboardcount = service.totalBoardCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String ps = "";
        String cp = "";

        //상세보기 >> 다시  LIST 넘어올때  >> 현재 페이지 설정
        //List 페이지 처음 호출 ...

        if(request.getParameter("ps") == null || request.getParameter("ps").trim().isEmpty()){
            System.out.println(request.getParameter("ps"));
            //default 값 설정
            ps = "5"; //5개씩
        } else {
            System.out.println(request.getParameter("ps"));
            ps = request.getParameter("ps");
        }
        if(request.getParameter("cp") == null || request.getParameter("cp").trim().isEmpty()){
            //default 값 설정
            cp = "1"; // 1번째 페이지 보겠다
        } else {
            cp = request.getParameter("cp");
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

        System.out.println("pagesize : " + pagesize);

        //전체 목록 가져오기
        List<Board> list = null;
        try {
            list = service.list(cpage, pagesize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //pager 생성해서 던져주기
        ThePager pager = new ThePager(totalboardcount, cpage, pagesize, 3, "board_list.jsp");
        request.setAttribute("pager", pager);

        System.out.println("pagesize : " + pagesize);
        request.setAttribute("pagesize", pagesize);

		request.setAttribute("cpage", cpage);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("totalboardcount", totalboardcount);
		request.setAttribute("list", list);
        //board 객체 만들어서 던져주기


		forward.setPath("/board/board_list.jsp");
//        forward.setRedirect(true);
		return forward;
    }
}

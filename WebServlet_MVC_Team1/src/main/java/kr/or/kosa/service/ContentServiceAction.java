package kr.or.kosa.service;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.BoardDao;
import kr.or.kosa.dto.Board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServiceAction implements Action {
    BoardDao dao;

    {
        try {
            dao = new BoardDao();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();

        String idx= request.getParameter("idx"); //글번호 받기

        //글 번호를 가지고 오지  않았을 경우 예외처리
        if(idx == null || idx.trim().equals("")){
            forward.setPath("/board/board_list.jsp");
            return forward; //더 이상 아래 코드가 실행되지 않고 클라이언트에게 바로 코드 전달
        }

        idx=idx.trim();
        //http://192.168.0.12:8090/WebServlet_5_Board_Model1_Sample/board/board_content.jsp?idx=19&cp=1&ps=5
        //board_content.jsp?idx=19&cp=1&ps=5  //다시 목록으로 갔을때  ... cp , ps 가지고 ...
        //why: 목록으로 이동시 현재 page 유지하고 싶어요
        String cpage = request.getParameter("cp"); //current page
        String pagesize = request.getParameter("ps"); //pagesize

        //List 페이지 처음 호출 ...
        if(cpage == null || cpage.trim().equals("")){
            //default 값 설정
            cpage = "1";
        }

        if(pagesize == null || pagesize.trim().equals("")){
            //default 값 설정
            pagesize = "5";
        }

        //상세보기 내용
        BoardService service = BoardService.getInBoardService();


        boolean isread = false;
        Board board = null;
        try {
            //옵션
            //조회수 증가
            isread = service.addReadNum(idx);

            //데이터 조회 (1건 (row))
            board = service.content(Integer.parseInt(idx));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        if(isread)System.out.println("조회증가 : " + isread);

        request.setAttribute("board", board);
        forward.setPath("/board/board_list.jsp");
        return forward;
    }
}

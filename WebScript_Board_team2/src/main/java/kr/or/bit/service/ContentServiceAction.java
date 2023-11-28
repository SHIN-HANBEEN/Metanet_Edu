package kr.or.bit.service;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Reply;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ContentServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
        ActionForward forward = new ActionForward();
        String idx = request.getParameter("idx"); //글번호 받기

        //서비스생성
        BoardService service = BoardService.getInBoardService();

        //글 번호를 가지고 오지  않았을 경우 예외처리
        if (idx == null || idx.trim().equals("")) {
            forward.setRedirect(true);
            forward.setPath("board_list.jsp");
            return forward;
        }

        idx = idx.trim();
        //http://192.168.0.12:8090/WebServlet_5_Board_Model1_Sample/board/board_content.jsp?idx=19&cp=1&ps=5
        //board_content.jsp?idx=19&cp=1&ps=5  //다시 목록으로 갔을때  ... cp , ps 가지고 ...
        //why: 목록으로 이동시 현재 page 유지하고 싶어요
        String cpage = request.getParameter("cp"); //current page
        String pagesize = request.getParameter("ps"); //pagesize

        //List 페이지 처음 호출 ...
        if (cpage == null || cpage.trim().equals("")) {
            //default 값 설정
            cpage = "1";
        }

        if (pagesize == null || pagesize.trim().equals("")) {
            //default 값 설정
            pagesize = "5";
        }

        //옵션
        //조회수 증가
        boolean isread = new BoardDao().getReadNum(idx);
        if (isread) System.out.println("조회증가 : " + isread);

        //댓글 가져오는 로직
        List<Reply> replyList = service.replyList(request.getParameter("idx"));

        request.setAttribute("cpage", cpage);
        request.setAttribute("pagesize", pagesize);

        //데이터 조회 (1건 (row))
        Board board = new BoardDao().getContent(Integer.parseInt(idx));
        System.out.println(board); //board 출력
        request.setAttribute("board", board); //board 로 글 보내주기
        System.out.println(replyList);
        request.setAttribute("replylist", replyList); //reply 댓글 목록 보내기

        forward.setPath("/board/board_content.jsp");

        return forward;
    }
}

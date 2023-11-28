package kr.or.bit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.bit.dto.Reply;
import kr.or.bit.service.BoardService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WriteReplyServlet")
public class InsertReply extends HttpServlet {

    public InsertReply() {
        super();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService service = BoardService.getInBoardService();
        System.out.println(req.getParameter("idx"));
        List<Reply> replyList = service.replyList(req.getParameter("idx"));

        // Convert the replyList to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReplyList = objectMapper.writeValueAsString(replyList);

        // Set the content type and write the JSON response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonReplyList);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService service = BoardService.getInBoardService();
        System.out.println(req.getParameter("idx"));
        List<Reply> replyList = service.replyList(req.getParameter("idx"));

        // Convert the replyList to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReplyList = objectMapper.writeValueAsString(replyList);

        // Set the content type and write the JSON response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonReplyList);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}

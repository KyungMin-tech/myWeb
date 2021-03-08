package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
//입력된 글 처리
public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");//한글 인코딩
		BoardVO article = new BoardVO();//데이터처리 빈
		article.setNum(Integer.parseInt(request.getParameter("nu")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPass(request.getParameter("pass"));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setStep(Integer.parseInt(request.getParameter("step")));
		article.setDepth(Integer.parseInt("depth"));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		BoardDAO dbPro = BoardDAO.getInstance();
		dbPro.insertArticle(article);
		return "/board/writePro.jsp";
	}

}

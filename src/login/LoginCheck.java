package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// db���� ����� ���� ��ȸ �̺κ��� �ڵ��� �����ؼ� ����� ����
		// db���� ��ȸ�� ������� ���̵� ����� ��ġ�ϴ� ���
		// Ŭ���̾�Ʈ�� ������ HttpSession��ü�� ���� ��Ų��.
		String dbID = "admin";
		String dbPWD = "1234";
		if(dbID.equals(id) && dbPWD.equals(pwd)) {
			// HttpSession��ü ���
			HttpSession session = request.getSession();
			//Ŭ���̾�Ʈ�� ������ HttpSession��ü�� ����
			session.setAttribute("user", id);
		}
		response.sendRedirect("Login");
		
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

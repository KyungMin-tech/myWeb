package sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
        super();
        System.out.println("LifeServlet의 생성자 호출됨...");
    }


	@Override
	// LifeServlet의 초기화 작업을 담당한다.
	// Servlet객체 생성시 단 한번 수행됨
	public void init() throws ServletException {
		System.out.println("init() 호출됨...");
	}

	// LifeServlet 객체가 WAS에서 소멸될 때 수행됨.
	public void destroy() {
		System.out.println("destroy() 호출됨...");
	}
	
	// 클라이언트의 연결요청이 있을 때 마다 호출된다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출됨...");
	}
}

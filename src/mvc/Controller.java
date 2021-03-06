package mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	// ��ɾ�� ó��Ŭ������ ���εǾ� �մ� properties ������
	// �о Map��ü�� commandMap�� ����
	// ��ɾ�� ó�� Ŭ������ ���εǾ� �ִ� properties ������
	// Command.properties����

	public void init(ServletConfig config) throws ServletException {
		// web.xml���� propertyConfig�� �ش��ϴ� init-param�� ���� �о��
		String props = config.getInitParameter("propertyConfig");
		// ��ɾ�� ó��Ŭ������ ���������� ������ Properties��ü ����
		Properties pr = new Properties();
		String path = config.getServletContext().getRealPath("/WEB-INF");
		FileInputStream f = null;
		try {
			// Command.properties������ ������ �о��
			f = new FileInputStream(new File(path, props));
			// Command.properties������ ������ Properties��ü�� ����
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}
		// Iterator��ü�� Enumeration���並 Ȯ���Ų ������ ��ü
		Iterator<Object> keyIter = pr.keySet().iterator();
		// ��ü�� �ϳ��� ������ �� ��ü������ Properties��ü�� ����� ��ü�� ����
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);
			try {// �ش� ���ڿ��� Ŭ������ �����.
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();// �ش�Ŭ������ ��ü�� ����
				// Map��ü�� commandMap�� ��ü ����
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// get����� ���� �޼���
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// post����� ���� �޼���
		requestPro(request, response);
	}

	// ������� ��ó�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandProcess com = null;
		try {
			String command = request.getRequestURI();
			System.out.println("getRequestURI : " + command);
			System.out.println("getContextPath : " + request.getContextPath());
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			System.out.println("ReGetRequestURI : " + command);
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}

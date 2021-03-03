package bbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
   }
   
   // DB Insert �۾��� �����ϴ� ���� => �Ѱ��� �۾��� ����ܴ� = ���� å���� ��Ģ
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // ���ڵ�
      request.setCharacterEncoding("utf-8");
      
      String writer = request.getParameter("writer");
      String memo = request.getParameter("memo");
      
      System.out.println(writer);
      System.out.println(memo);
      
      String sql = "insert into visit(no, writer, memo, regdate) values (visit_seq.nextval, ?, ?, sysdate)";
      
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, writer);
         pstmt.setString(2, memo);
         pstmt.executeUpdate();
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(pstmt != null) pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
         try {
            if(con != null) con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
      // ����η� ���� : ���� ��ο��� ã�´�.
      // redirect : ���û
      response.sendRedirect("VisitList");
   }

}
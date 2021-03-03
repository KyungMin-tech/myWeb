<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, jdbc.*" %>
<%
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	ConnectionPool pool = ConnectionPool.getInstance();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String id = "",
			passwd = "",
			name = "",
			mem_num1 = "",
			mem_num2 = "",
			e_mail = "",
			phone = "",
			zipcode = "",
			address = "",
			job = "";
	int counter = 0;
	try {
		// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
		conn = pool.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM TEMPMEMBER");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body bgcolor="#ffffcc">
<h2>JSP 스트립틀릿에서 데이터베이스 연동 예제입니다...</h2><br>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
	<tr>
		<td><Strong>ID</Strong></td>
		<td><Strong>PASSWD</Strong></td>
		<td><Strong>NAME</Strong></td>
		<td><Strong>MEM_NUM1</Strong></td>
		<td><Strong>MEM_NUM2</Strong></td>
		<td><Strong>E_MAIL</Strong></td>
		<td><Strong>PHONE</Strong></td>
		<td><Strong>ZIPCODE/ADDRESS</Strong></td>
		<td><Strong>JOB</Strong></td>	
	</tr>
	<%
		if(rs != null) {
			while(rs.next()) {
				id = rs.getString("id");
				passwd = rs.getString("passwd");
				name = rs.getString("name");
				mem_num1 = rs.getString("mem_num1");
				mem_num2 = rs.getString("mem_num2");
				e_mail = rs.getString("e_mail");
				phone = rs.getString("phone");
				zipcode = rs.getString("zipcode");
				address = rs.getString("address");
				job = rs.getString("job");
	%>
	<tr>
		<td><%= id %></td>
		<td><%= passwd %></td>
		<td><%= name %></td>
		<td><%= mem_num1 %></td>
		<td><%= mem_num2 %></td>
		<td><%= e_mail %></td>
		<td><%= phone %></td>
		<td><%= zipcode %>/<%= address %></td>
		<td><%= job %></td>
	</tr>
	<%
				counter++;
			} // end while
		} // end if
	%>
</table>
<br/>
total records : <%= counter %>

<%
	} catch(SQLException sqlException) {
		System.out.println("sql exception");
	} catch(Exception exception) {
		System.out.println("exception");
	} finally {
		if(rs != null)
			try { rs.close(); } catch(SQLException ex) {}
		if(stmt != null)
			try { stmt.close(); } catch(SQLException ex) {}
		if(conn != null)
			try { 
				// conn.close();
				pool.releaseConnection(conn);
			} catch(SQLException ex) {}
	}
%>
</body>
</html>
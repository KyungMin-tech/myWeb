<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% StudentDAO dao = StudentDAO.getInstance(); %>

<%
	String id = request.getParameter("id");
	boolean check = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css"/>
<script src="script.js"></script>
</head>
<body bgcolor="#ffffcc">
	<br/>
	<center>
		<b><%=id %></b>
		<%
			if(check) {
				out.println("는 이미 존재하는 ID입니다.<br/>");
			} else {
				out.println("는 사용 가능 합니다.<br/>");
			}
		%>
		<a href="#" onClick="javascript:self.close()">닫기</a>
	</center>
</body>
</html>
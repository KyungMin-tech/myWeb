<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body bgcolor="#ffffcc">
<h2>Beans를 사용한 데이터베이스 연동 예제입니다...</h2>
<br>
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
	<jsp:useBean id="dao" class="jdbc.tempMemberDAO" scope="page" />
	<%
		Vector<tempMemberVO> vlist = dao.getMemberList();
		int counter = vlist.size();
		for(int i = 0; i < vlist.size(); i++) {
			tempMemberVO vo = vlist.elementAt(i);
	%>
	<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getPasswd() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getMem_num1() %></td>
		<td><%= vo.getMem_num2() %></td>
		<td><%= vo.getEmail() %></td>
		<td><%= vo.getPhone() %></td>
		<td><%= vo.getZipcode() %>/<%= vo.getAddress() %></td>
		<td><%= vo.getJob() %></td>
	
	<%} %>
	</tr>
</table><br>
total records : <%= counter %>
</body>
</html>
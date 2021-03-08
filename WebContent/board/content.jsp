<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="view/color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body bgcolor="${bodyback_c}">
<center><b>글 내용 보기</b>
<br>
<form>
	<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr height="30">
			<td width="125" bgcolor="${value_c}" align="center">글번호</td>
			<td width="125" align="center">${article.num}</td>
			<td width="125" bgcolor="${value_c}" align="center">조회수</td>
			<td width="125" align="center">${article.readcount}</td>
		</tr>
		<tr height="30">
			<td width="125" bgcolor="${value_c}" align="center">작성자</td>
			<td width="125" align="center">${article.writer}</td>
			<td width="125" bgcolor="${value_c}" align="center">작성일</td>
			<td width="125" align="center">${article.regdate}</td>
		</tr>
		<tr>
			<td width="125" bgcolor="${value_c}" align="center">글제목</td>
			<td width="375" align="center" colspan="3">${article.subject}</td>
		</tr>
		<tr height="30">
			<td width="125" bgcolor="${value_c}" align="center">글내용</td>
			<td width="375" align="center" colspan="3"><pre>${article.content}</pre></td>
		</tr>
		<tr height="30">
			<td colspan="4" bgcolor="${value_c}" align="right">
				<input type="button" value="글수정" onclick="document.location.href='/myWeb/board/updateForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="글삭제" onclick="document.location.href='/myWeb/board/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="답글쓰기" onclick="document.location.href='/myWeb/board/writeForm.do?num=${article.num}&ref=${ref}&step=${step}&depth=${depth}'">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="글목록" onclick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'">
			</td>
		</tr>
	</table>
</form>
</center>
</body>
</html>
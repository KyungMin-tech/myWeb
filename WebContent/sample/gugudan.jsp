<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuGu Dan</title>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<% for(int i = 2; i < 10; i++) {%>
				<td><%= i %>&nbsp;단</td>
			<%} %>
		</tr>
		
		<% for(int k = 2; k <= 9; k++) {%> 
		</tr>
		<tr>	
			<td><%=k %></td>
			<% for(int j = 2; j <= 9; j++) {%>
			<td><%=k %> x <%=j %>= <%=k*j %></tr>
			<%} %>
		<%} %>
		</tr>
		
	</table>
</body>
</html>
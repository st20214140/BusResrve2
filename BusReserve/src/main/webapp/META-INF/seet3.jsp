<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int[][] seetFlag = new int[10][4];
	String[] state = {"〇", "×"};
	char[] charmap = {'A', 'B', 'C', 'D'};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form action="">
<body>
	<table border="10">
	<tr>
	<th>　</th>
	<th>A</th>
	<th>B</th>
	<th>C</th>
	<th>D</th>
	</tr>
	
	<% for(int i = 0; i < seetFlag.length; i++) { %>
		<tr>
		<th><%= i + 1 %></th>
		<% for(int j = 0; j < seetFlag[i].length; j++) { %>
			<td><button name="<%=charmap[j] %><%= i + 1 %>" ><%= state[seetFlag[i][j]] %></button></td>
		<% } %>
		</tr>
	<% } %>
	
	</table>
</form>
</body>
</html>
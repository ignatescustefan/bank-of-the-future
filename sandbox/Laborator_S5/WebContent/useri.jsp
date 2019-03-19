<%@page import="java.util.Map"%>
<%@page import="ro.proiect.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bună, <%=session.getAttribute("username")%></h1>
	
	<!-- afisare lista de useri -->
	<table>
	<thead>
		<tr><th>User</th><th>Parola</th></tr>
	</thead>
	<tbody>
		<% for(Map.Entry<String,String> e:UserDAO.instance().getUseri().entrySet()) { %>
		<tr><td><%=e.getKey() %></td><td><%=e.getValue() %></td></tr>
		<%} %>
	</tbody>
	</table>
</body>
</html>
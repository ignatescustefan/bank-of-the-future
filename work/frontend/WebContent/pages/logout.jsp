<%
System.out.println("Logout");
session.invalidate();
response.sendRedirect("../login.jsp");
%>

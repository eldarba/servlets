<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<%
		//PrintWriter out = response.getWriter();
		// out.println("<html>");
		// out.println("<body>");
		// out.println("<h1>Online Store</h1>");
		// out.println("<hr>");
		// out.println("<h3>Welcome " + request.getAttribute("userName") + "!</h3>");
		// out.println("Last Visit: " + lastVisit);
		//
		// out.println("</body>");
		// out.println("</html>");
	%>
	<h1>Online Store</h1>
	<hr>
	<h3>Welcome <%= request.getAttribute("userName")%> !</h3>
	Last Visit:
	<%=request.getAttribute("lastVisit")%>
	
	<h3>What would you like to do?</h3>
	<a href="Controller?command=startShopping">Start Shopping</a>
</body>
</html>
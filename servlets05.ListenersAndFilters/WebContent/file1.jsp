<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to JSP file1</h1>
	<%
		// this is the service method
		int r = (int) (Math.random() * 11);
	%>

	your lucky number is
	<!-- writing to client -->
	<%=r%>

</body>
</html>
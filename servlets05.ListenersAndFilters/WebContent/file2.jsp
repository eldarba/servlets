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
	<h1>Welcome to JSP file2</h1>

	<%!// this is the servlet class (to write fields and methods)
	// fields
	private String address;
	private static int hitCounter;

	// method
	public int sum(int a, int b) {
		return a + b;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	%>
	
	<div>sum of a and b parameters =
	<%
	int a, b;
	// to get request parameters use the request variable
	a = Integer.parseInt(request.getParameter("a"));
	b = Integer.parseInt(request.getParameter("b"));
	%>
	<%=sum(a, b) %>
	</div>
	
	
	
	
	
	
	

</body>
</html>
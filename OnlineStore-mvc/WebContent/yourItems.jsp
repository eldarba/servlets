<%@page import="db.Item"%>
<%@page import="helpers.ShoppingCart"%>
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
	<%
		Object errorMessage = request.getAttribute("errorMessage");
		if (errorMessage == null) {
			out.print("Item added<br>");
		} else {%>
		<div style="color: red;">Item not added</div>
		<%
			out.print("error: " + errorMessage + "<br>");
		}
	%>

	<h3>Your Cart Items</h3>
	<%
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		for (Item item : cart.getItems()) {
			out.print(item + "<br>");
		}
	%>
	
	<a href="shop.jsp">back to shopping</a>
</body>
</html>
<%@page import="db.Item"  session="false"%>
<%@page import="db.StoreItems"%>
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
	<h1>Shop</h1>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="addItem"> enter
		item name<br> <input name="itemName"><br>
		<button type="submit">add to cart</button>
	</form>
	<h3>Items in Store</h3>
	<%
		StoreItems store = (StoreItems) request.getServletContext().getAttribute("storeItems");
		for (Item item : store.getItems()) {
	%>
	<%=item%><br>
	<%
		}
	%>

</body>
</html>
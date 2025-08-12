<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("player");
	rs.next();
	%>
	<h2>Enter Updated Details</h2>
	<form action="update-player" method="post">
	<input type="number" value="<%=rs.getInt(1)%>" name="id" readonly="readonly">
	<input type="text" value="<%=rs.getString(2) %>" name="title">
	<input type="number" value="<%=rs.getInt(3) %>" name="age">
	<input type="text" value="<%=rs.getString(4) %>" name="team">
	<input type="text" value="<%=rs.getString(5) %>" name="nationality">
	<input type="submit" value="Update">
	</form>


</body>
</html>
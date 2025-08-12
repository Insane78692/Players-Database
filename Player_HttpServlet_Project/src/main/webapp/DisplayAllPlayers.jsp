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
	ResultSet rs = (ResultSet) request.getAttribute("players");
	%>

	<h1>All Players Details :-</h1>
	<table border="">

		<tr>
			<th>PlayerId</th>
			<th>Title</th>
			<th>Age</th>
			<th>Team</th>
			<th>Nationality</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%while(rs.next()){ %>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getInt(3) %></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><a href="findbyid?id=<%=rs.getInt(1)%>">Update</a></td>
				<td><a href="deletebyid?id=<%=rs.getInt(1) %>">Delete</a></td>
			</tr>
		<%} %>
		
	</table>
	<h2><a href="Index.jsp">Go Back to the DashBoard</a></h2>

</body>
</html>
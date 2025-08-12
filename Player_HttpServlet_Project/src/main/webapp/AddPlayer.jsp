<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter The Player Details</h1>
<form action="add-players" method="post">
<input type="number" placeholder="Enter the Id :- " name="id">
<input type="text" placeholder="Enter the Title :- " name="title">
<input type="number" placeholder="Enter the Age :- " name="age">
<input type="text" placeholder="Enter the Team :- " name="team">
<input type="text" placeholder="Enter the Nationality :- " name="nationality">
<input type="submit" placeholder="Add">

</form>

</body>
</html>
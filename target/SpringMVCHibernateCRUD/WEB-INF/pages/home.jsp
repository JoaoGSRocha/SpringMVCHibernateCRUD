<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		
		<table border="1">

			<th>FB ID</th>
			<th>Name</th>
			<th>UserPostsID</th>
			<th>Points</th>
			<th>Age</th>
			<th>Action</th>

			<c:forEach var="user" items="${listUser}">
				<tr>

					<td>${user.userFBID}</td>
					<td>${user.fbName}</td>
					<td>${user.userPostsID}</td>
					<td>${user.points}</td>
					<td>${user.age}</td>
					<td><a href="editUser?userID=${user.userID}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteUser?userID=${user.userID}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New user Register <a href="newUser">here</a>
		</h4>
	</div>
</body>
</html>
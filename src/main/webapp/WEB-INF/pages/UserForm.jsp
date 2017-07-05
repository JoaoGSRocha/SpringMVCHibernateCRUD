<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit User</h1>
        <form:form action="saveUser" method="post" modelAttribute="User">
        <table>
            <form:hidden path="userID"/>
			<tr>
                <td>FB  ID:</td>
                <td><form:input path="userFBID" /></td>
            </tr>

            <tr>
                <td>FB Name:</td>
                <td><form:input path="fbName" /></td>
            </tr>
            <tr>
                <td>UserPostsID:</td>
                <td><form:input path="userPostsID" /></td>
            </tr>
            <tr>
                <td>Points:</td>
                <td><form:input path="points" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>
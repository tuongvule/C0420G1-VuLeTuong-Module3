<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2020
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show List of Users</title>

</head>
<body>
<h1>User List</h1>
<table border=0 style="width: 50%; border-collapse: collapse; color: blue">
    <tr>
        <td><a href="/userServlet?action=create"><input type="button" value="Create New User"></a></td>
        <td><a href="/userServlet?action=search"><input type="button" value="Search User"></a></td>
    </tr>
</table>
<table>
    <table border=1 style="width: 50%; border-collapse: collapse; color: blue">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/userServlet?action=view&id=${user.id}">${user.name}</a></td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td><a href="/userServlet?action=edit&id=${user.id}">edit</a></td>
                <td><a href="/userServlet?action=delete&id=${user.id}">delete</a></td>
            </tr>

        </c:forEach>
    </table>
</table>
</body>
</html>

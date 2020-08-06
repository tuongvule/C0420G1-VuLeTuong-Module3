<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-Aug-20
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<h1>User list</h1>
<table border=0 style="width: 30%">
    <tr>
        <td><a href="/user-list?action=create"><input type="button" value="Create new user"></a></td>
        <td><a href="/user-list?action=search-by-country"><input type="button" value="Search user by country"></a></td>
        <td><a href="/user-list?action=user-list-sorted-by-name"><input type="button" value="User list sorted by name"></a></td>
        <td><a href="/user-list"><input type="button" value="Back to menu"></a></td>
    </tr>
</table>
<table border="1">
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
            <td>${user.getId()}</td>
            <td><a href="/user-list?action=view&id=${user.getId()}">${user.getName()}</a></td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
            <td><a href="/user-list?action=edit&id=${user.getId()}">edit</a></td>
            <td><a href="/user-list?action=delete&id=${user.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

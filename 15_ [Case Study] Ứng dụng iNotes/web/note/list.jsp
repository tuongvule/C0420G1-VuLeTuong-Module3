<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/7/2020
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Notes</title>
</head>
<body>

<h1>User list</h1>
<table border=0 style="width: 30%">
    <tr>
        <td><a href="/noteServlet?action=create"><input type="button" value="Create new note"></a></td>
        <td><a href="/noteServlet?action=search-by-title"><input type="button" value="Search note by title"></a></td>
        <td><a href="/noteServlet?action=user-list-sorted-by-name"><input type="button" value="User list sorted by name"></a></td>
        <td><a href="/user-list"><input type="button" value="Back to menu"></a></td>
    </tr>
</table>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Title</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${noteList}" var="note">
        <tr>
            <td>${note.noteId}</td>
            <td><a href="/user-list?action=view&id=${user.getId()}">${user.name}</a></td>
            <td>${note.title}</td>
            <td><a href="/user-list?action=edit&id=${user.getId()}">edit</a></td>
            <td><a href="/user-list?action=delete&id=${user.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

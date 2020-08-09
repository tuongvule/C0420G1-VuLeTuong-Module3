<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05-Aug-20
  Time: 03:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h1>Delete user</h1>
<p>
    <a href="/user-list"><input type="button" value="Back to menu"></a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["user"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
                <td><a href="/user-list"><input type="button" value="Back to menu"></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

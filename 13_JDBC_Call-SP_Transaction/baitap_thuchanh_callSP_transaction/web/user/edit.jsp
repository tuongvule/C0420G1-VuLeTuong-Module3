<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2020
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Form</title>
</head>
<body>
<h1>Edit user</h1>
<p>
    <c:if test='${message!=nul}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/userServlet"><input type="button" value="Back to Menu"></a>
</p>
<form method="post">
    <fieldset>
        <legend>Edit user information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${user.name}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email" value="${user.email}"></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" id="country" value="${user.country}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update user" ></td>
        </table>
    </fieldset>
</form>
</body>
</html>

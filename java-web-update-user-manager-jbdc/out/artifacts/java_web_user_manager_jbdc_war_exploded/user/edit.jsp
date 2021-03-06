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
</head>
<body>
<h1>Edit user</h1>
<p>
    <c:if test='${requestScope["message"]!=nul}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/user-list"><input type="button" value="Back to menu"></a>
</p>
<form method="post">
    <fieldset>
        <legend>Edit user information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update user"></td>
        </table>
    </fieldset>
</form>

</body>
</html>

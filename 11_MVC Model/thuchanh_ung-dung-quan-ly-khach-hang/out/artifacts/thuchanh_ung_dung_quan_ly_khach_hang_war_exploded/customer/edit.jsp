
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2020
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1>
<p>
    <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>
<p><a href="/customers">Back to customer list</a></p>
<form method="post">
<fieldset>
    <legend>Customer information</legend>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"  value="${customer.name}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.address}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update customer"></td>
        </tr>
    </table>
</fieldset>
</form>
</body>
</html>

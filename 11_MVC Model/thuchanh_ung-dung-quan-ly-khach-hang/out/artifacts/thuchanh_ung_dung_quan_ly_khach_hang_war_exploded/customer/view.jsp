<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2020
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${customer.address}</td>
    </tr>
</table>
</body>
</html>

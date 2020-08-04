<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2020
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/productServlet">Back to Product list</a>
</p>
<table width=20%>
    <tr>
        <td>Name: </td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>price: </td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${product.manufacturer}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${product.description}</td>
    </tr>
</table>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2020
  Time: 2:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Products</title>
</head>
<body>
<h1 style="color: green">List of Products</h1>
<p>
    <a href="/productServlet?action=search" style="color: blue">Search By Name</a>
</p>
<p>
    <a href="/productServlet?action=create" style="color: blue">Create New Product</a>
</p>
<table border="1" style="color: red; border-collapse: collapse; width: 50%">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><a href="/productServlet?action=view">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.manufacturer}</td>
            <td>${product.description}</td>
            <td><a href="/productServlet?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

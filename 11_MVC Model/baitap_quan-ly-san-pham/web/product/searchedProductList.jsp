<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2020
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Searched Products</title>
</head>
<body>
<h1>Product list by name</h1>
<table border="2" style="border-collapse: collapse; text-align: center" width=100% >
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${searchedProductList}">
        <tr>
            <td><a href="/productServlet?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.manufacturer}</td>
            <td>${product.description}</td>
            <td><a href="/productServlet?action=edit&id=${product.id}">edit</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

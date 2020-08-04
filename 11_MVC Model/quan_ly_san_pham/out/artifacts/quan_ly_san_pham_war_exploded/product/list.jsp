<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1 style="text-align: center">Products</h1>
<p>
    <a href="/productServlet?action=search" style="color: red">Search By Name</a>
</p>
<p>
    <a href="/productServlet?action=create" style="color: blue">Create new product</a>
</p>
<table border="2" style="border-collapse: collapse; text-align: center" width=100% >
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Product Description</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${listProduct}">
        <tr>
            <td><a href="/productServlet?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.productDescription}</td>
            <td>${product.producer}</td>
            <td><a href="/productServlet?action=edit&id=${product.id}">edit</a></td>
            <td><a href="/productServlet?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

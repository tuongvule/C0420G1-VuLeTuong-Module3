<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2020
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<p>
    <c:if test="${message=!null}">
        <span>${message}</span>
    </c:if>
</p>
<p>
    <a href="/productServlet">Back to List of Products</a>
</p>
<form method="post">
    <h1>Edit Product</h1>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Manufactuer: </td>
                <td><input type="text" name="manufacturer" value="${product.manufacturer}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="${product.description}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Product"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2020
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/productServlet">Back to Product List</a>
</p>
<form method="post" style="width: 400px">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
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
            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/productServlet">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

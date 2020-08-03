<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/3/2020
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h1>Delete Customer</h1>
<p>
    <a href="/customers">Back to menu list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer Informaiton</legend>
        <table>
            <tr>
                <td>Name</td>
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
            <tr>
                <td><input type="submit" value="Delete Customer"></td>
                <td><a href="/customers">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

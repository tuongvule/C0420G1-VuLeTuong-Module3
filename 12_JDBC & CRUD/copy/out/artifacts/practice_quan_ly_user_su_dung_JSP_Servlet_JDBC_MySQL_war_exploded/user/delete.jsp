<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2020
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Form</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/userServlet">Back to Product List</a>
</p>
<form method="post" style="width: 400px">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${user.country}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Product"></td>
                <td><a href="/userServlet"><input type="button" value="Back to menu"></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</form>
</body>
</html>

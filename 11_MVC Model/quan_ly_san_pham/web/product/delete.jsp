
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/productServlet">Back to customer list</a>
</p>
<form method="post" style="width: 400px">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${productDelete.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${productDelete.price}</td>
            </tr>
            <tr>
                <td>Product Description: </td>
                <td>${productDelete.productDescription}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${productDelete.producer}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/productServlet">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
    <style>
        .message{
            color: greenyellow;
        }
    </style>
</head>
<body>
<h1>Create New Product</h1>
<c:if test="${message != null}">
<span class="message">${message}</span>
</c:if>
<p><a href="/productServlet" style="color: blue">Back to products list</a></p>
<form method="post">
    <fieldset style="width: 400px">
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Product Description</td>
                <td><input type="text" name="productDescription" id="productDescription"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type="text" name="producer" id="producer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>

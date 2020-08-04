<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<h1>Update product</h1>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/productServlet" style="color: blue">Back to products list</a>
</p>
<form method="post" style="width: 400px">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${productEdit.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${productEdit.price}"></td>
            </tr>
            <tr>
                <td>Product Description: </td>
                <td><input type="text" name="productDescription" id="productDescription" value="${productEdit.productDescription}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" id="producer" value="${productEdit.producer}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

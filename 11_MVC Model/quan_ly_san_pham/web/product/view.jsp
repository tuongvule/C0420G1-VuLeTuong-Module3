
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/productServlet">Back to customer list</a>
</p>
<table width=20%>
    <tr>
        <td>Name: </td>
        <td>${productView.name}</td>
    </tr>
    <tr>
        <td>price: </td>
        <td>${productView.price}</td>
    </tr>
    <tr>
        <td>Product Description: </td>
        <td>${productView.productDescription}</td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td>${productView.producer}</td>
    </tr>
</table>
</body>
</html>

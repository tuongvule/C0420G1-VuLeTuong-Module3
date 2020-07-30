<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/30/2020
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<p>Rate: <%=request.getAttribute("rate")%></p>
<p>USD: <%=request.getAttribute("usd")%></p>
<p>VND: <%=request.getAttribute("vnd")%></p>
</body>
</html>

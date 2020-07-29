<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/27/2020
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show_result</title>
</head>
<body>
<h2>Result: </h2>
<p><%=request.getAttribute("first_operand")%> <%=request.getAttribute("operator")%> <%=request.getAttribute("second_operand")%>
    = <%=request.getAttribute("result_print")%></p>

</body>
</html>

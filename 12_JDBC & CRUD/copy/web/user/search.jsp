<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2020
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Form</title>
</head>
<body>
h1>Search user</h1>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"]!=nul}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p>
    <a href="/userServlet"><input type="button" value="Back to menu"></a>
</p>
<form method="post">
    <fieldset>
        <legend>Search user by country</legend>
        <table>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search user"></td>
        </table>
    </fieldset>
</form>
</body>
</html>


<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/25/2020
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showlist</title>
    <style>
        th{
            color: red;
        }
        td{
            color: blue;
        }
        table{
            height: 100px;
            width: 200px;
            border: 1px;
            border-collapse: collapse;

        }
    </style>
</head>

<body>



<% List<Student> studentList2 = (List<Student>) request.getAttribute("studentList");%>
<% for (Student student :studentList2){%>
    <%=student.getId()%>
    <%=student.getName()%>
    <%=student.getBirthday()%>
    <br>
<%} %>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Mark</th>
        <th>Type</th>
    </tr>


<%--        <% for (Student student: studentList2){%>--%>
<%--    <tr>--%>
<%--        <td><%=student.getId()%></td>--%>
<%--        <td><%=student.getName()%></td>--%>
<%--        <td><%=student.getBirthday()%></td>--%>
<%--    </tr>--%>
<%--    <%}%>--%>
    <c:forEach var="student" items="${studentList}">
        <tr>
<%--            <td>${student.id}</td>--%>
<%--            <td>${student.name}</td>--%>
<%--            <td>${student.birthday}</td>--%>
<%--            <td>${student.mark}</td>--%>

<%--    Dùng c:out nó sẽ bảo mật hơn--%>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td><c:out value="${student.birthday}"></c:out></td>
            <td><c:out value="${student.mark}"></c:out></td>

            <td>
                <c:choose>
                    <c:when test="${student.mark>9}"> Excellent</c:when>
                    <c:when test="${student.mark>8 && student.mark<=9}"> Good</c:when>
                    <c:when test="${student.mark>=7 && student.mark<=8}"> Quite</c:when>
                    <c:when test="${student.mark<7}"> Bad </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

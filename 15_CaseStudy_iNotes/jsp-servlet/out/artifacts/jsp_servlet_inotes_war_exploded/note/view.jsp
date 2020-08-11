<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Note</title>
</head>
<body>
<h1>Note details</h1>
<p>
    <a href="/noteServlet"><input type="button" value="Back to NoteList"></a>
</p>
<table border="1"  width=60% style="border-collapse: collapse">
    <tr>
        <td>Title: </td>
        <td>${note.title}</td>
    </tr>
    <tr>
        <td>Content</td>
        <td>${note.content}</td>
    </tr>
    <tr>
        <td>Classify: </td>
        <c:forEach var="noteType" items="${noteTypeList}">
            <c:if test="${noteType.noteTypeId == note.typeId}">
                <td> <c:out value="${noteType.name}"></c:out></td>
            </c:if>
        </c:forEach>
    </tr>
    <tr>
        <td><a href="/noteServlet?action=edit&noteId=${note.noteId}">Edit</a></td>
        <td><a href="/noteServlet?action=delete&noteId=${note.noteId}">Delete</a></td>
    </tr>
</table>
</body>
</html>

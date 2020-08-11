<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Notes</title>
</head>
<body>
<h1>Note List</h1>
<table border=0 style="width: 30%">
    <tr>
        <td>
            <form>
                <input type="hidden" name="action" value="find">
                <input type="text" name="title" id="title" placeholder="Find note by title">
                <input type="submit" value="Search">
            </form>
        </td>

        <td><a href="/noteServlet?action=create"><input type="button" value="Create New Note"></a></td>
        <td><a href="/noteServlet?action=sort"><input type="button" value="NoteList Sorted By Name"></a></td>
        <td><a href="/noteServlet"><input type="button" value="Back To Menu"></a></td>
    </tr>
</table>
<table border="1" style="border-collapse: collapse; width: 50%">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Classify</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${noteList}" var="note">
        <tr>
            <td><c:out value="${note.noteId}" > </c:out></td>
            <td>
                <a href="/noteServlet?action=view&noteId=${note.noteId}">
                    <c:out value="${note.title}"></c:out>
                </a>
            </td>

            <c:forEach var="noteType" items="${noteTypeList}">
                <c:if test="${noteType.noteTypeId == note.typeId}">
                    <td> <c:out value="${noteType.name}"></c:out></td>
                </c:if>
            </c:forEach>

            <td><a href="/noteServlet?action=edit&noteId=${note.noteId}">Edit</a></td>
            <td><a href="/noteServlet?action=delete&noteId=${note.noteId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

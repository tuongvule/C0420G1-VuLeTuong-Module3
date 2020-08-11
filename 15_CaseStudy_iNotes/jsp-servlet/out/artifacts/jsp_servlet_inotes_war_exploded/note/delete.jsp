<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h1>Delete note</h1>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>NoteId: </td>
                <td>${note.noteId}</td>
            </tr>
            <tr>
                <td>Title: </td>
                <td>${note.title}</td>
            </tr>
            <tr>
                <td>Content: </td>
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
                <td><a href="/noteServlet"><input type="button" value="Cancel"></a></td>
                <td><input type="submit" value="Delete Note"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

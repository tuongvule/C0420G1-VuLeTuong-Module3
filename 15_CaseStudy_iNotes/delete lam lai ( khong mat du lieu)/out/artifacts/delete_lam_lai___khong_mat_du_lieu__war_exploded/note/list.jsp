<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Management</title>
</head>
<body>
<div align="center">
    <h1>Note Management</h1>
    <table>
        <tr>
            <th>
                <h3>
                    <a href="/NoteManagementServlet?action=create"><input type="submit" value="Add New Note"></a>
                </h3>
            </th>
            <th>
                <h3>
                    <a href="/NoteManagementServlet?action=sort"><input type="submit" value="Sort Note By Title"></a>
                </h3>
            </th>
        </tr>
    </table>
    <form action="/NoteManagementServlet?action=search" method="post">
        <input type="text" name="title" id="title" placeholder="Search note by title">
        <input type="submit" value="Search">
    </form>
    <p>
        <c:if test="${message != null}">
            <a href="/NoteManagementServlet" class="message"><input type="submit" value="${message}"></a>
        </c:if>
    </p>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Note Type</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="note" items="${noteList}">
            <tr>
                <td><c:out value="${note.id}"/></td>
                <td><a href="/NoteManagementServlet?action=edit&id=${note.id}"><c:out value="${note.title}"/></a></td>
                    <c:forEach var="noteType" items="${noteTypeList}">
                        <c:if test="${note.type_Id == noteType.id_note_type}">
                       <td><c:out value="${noteType.name_type}"/></td>
                        </c:if>
                    </c:forEach>
                <td>
                    <a href="/NoteManagementServlet?action=edit&id=${note.id}"><input type="submit" value="Edit"></a>
                    <a href="/NoteManagementServlet?action=delete&id=${note.id}"><input type="submit" value="Delete"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

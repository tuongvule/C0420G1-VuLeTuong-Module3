<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"]!=nul}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <c:if test="${message != null}">
        <a href="/noteServlet"><input type="button" value="Back to menu"></a>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Edit note information</legend>
        <table>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title" value="${note.title}"></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><input type="text" name="content" value="${note.content}"></td>
            </tr>
            <tr>
                <td>Classify</td>
                <td>
                    <select name="typeId" id="">
                    <c:forEach var="noteType" items="${noteTypeList}">
                        <option value="${noteType.noteTypeId}"><c:out value="${noteType.name}"></c:out></option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td> <a href="/noteServlet"><input type="button" value="Cancel"></a></td>
                <td><input type="submit" value="Update Note"></td>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Management</title>
</head>
<body>
<p align="center">
    <a href="/NoteManagementServlet"><input type="submit" value="List All Note"></a>
</p>
<div align="center">
    <form method="post" style="width: 400px">
        <h3>Are you sure?</h3>
        <fieldset >
            <legend>Note Management</legend>
            <table>
                <c:if test="${noteDelete != null}">
                    <input type="hidden" name="delete_note" value="<c:out value='${noteDelete.delete_note}'></c:out>"/>
                </c:if>
                <tr>
                    <td>Title: </td>
                    <td>${noteDelete.title}</td>
                </tr>
                <tr>
                    <td>Content: </td>
                    <td>${noteDelete.content}</td>
                </tr>
                <tr>
                    <td>Note type: </td>
                    <c:forEach var="noteType" items="${noteTypeList}">
                        <c:if test="${noteDelete.type_Id == noteType.id_note_type}">
                            <td><c:out value="${noteType.name_type}"></c:out></td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>

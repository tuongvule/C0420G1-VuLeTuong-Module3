<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Management</title>
</head>
<body>
<div style="text-align: center">
    <h1>Note Management</h1>
</div>
<div align="center">
    <a href="/NoteManagementServlet"><input type="submit" value="List All Note"></a>
    <form action="/NoteManagementServlet?action=create" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New note</h2>
            </caption>
            <c:if test="${message != null}">
                <span class="message" style="color: blue">${message}</span>
            </c:if>
            <tr>
                <th>Title:</th>
                <td>
                    <input type="text" name="title" id="title" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Content:</th>
                <td>
                    <textarea cols="42px" rows="10px" type="text" name="content" id="content" size="45"></textarea>
                </td>
            </tr>
            <tr>
                <th>Note type:</th>
                <td>
                    <select name="noteTypeId" >
                        <c:forEach var="noteType" items="${noteTypeList}">
                            <option value="${noteType.id_note_type}"><c:out value="${noteType.name_type}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <a href="/NoteManagementServlet"><input type="button" value="Cancel"></a>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>

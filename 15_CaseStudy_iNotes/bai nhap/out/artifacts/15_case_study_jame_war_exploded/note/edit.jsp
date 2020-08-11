<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Management</title>
</head>
<body>
<div style="text-align: center">
    <h1>Note Management</h1>
    <p>
        <a href="/NoteManagementServlet"><input type="submit" value="List All Note"></a>
    </p>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Note
                </h2>
            </caption>
            <c:if test="${message != null}">
                <span class="message" style="color: blue">${message}</span>
            </c:if>
            <c:if test="${noteEdit != null}">
                <input type="hidden" name="id" value="<c:out value='${noteEdit.id}'></c:out>"/>
            </c:if>
            <tr>
                <th>Title :</th>
                <td>
                    <input type="text" name="title" size="45"
                           value="<c:out value='${noteEdit.title}'></c:out>"
                    />
                </td>
            </tr>
            <tr>
                <th>Content :</th>
                <td>
                    <input type="text" name="content" size="45"
                           value="<c:out value='${noteEdit.content}'></c:out>"
                    />
                </td>
            </tr>
            <tr>
                <th>Note type :</th>
                <td>
                    <select name="noteTypeId" >
                        <c:forEach var="noteType" items="${noteTypeList}">
                            <option value="${noteType.id_note_type}" ><c:out value="${noteType.name_type}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/noteServlet"><input type="button" value="Back To Menu"></a>
</p>
<form method="post">
    <fieldset>
        <legend>Add New Note</legend>
        <table>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title" ></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><input type="text" name="content" ></td>
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
                <td></td>
                <td><a href="/noteServlet"><input type="button" value="Cancel"></a><input type="submit" value="Save"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/10/2020
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>listcss</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--    <title>Bootstrap Table with Search Column Feature</title>--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f7f5f2;
            font-family: 'Roboto', sans-serif;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            color: #fff;
            background: #40b2cd;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .search-box {
            position: relative;
            float: right;
        }
        .search-box .input-group {
            min-width: 300px;
            position: absolute;
            right: 0;
        }
        .search-box .input-group-addon, .search-box input {
            border-color: #ddd;
            border-radius: 0;
        }
        .search-box input {
            height: 34px;
            padding-right: 35px;
            background: #f4fcfd;
            border: none;
            border-radius: 2px !important;
        }
        .search-box input:focus {
            background: #fff;
        }
        .search-box input::placeholder {
            font-style: italic;
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 6px 0;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
            position: relative;
            top: 2px;
        }
        table.table {
            table-layout: fixed;
            margin-top: 15px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table th:first-child {
            width: 60px;
        }
        table.table th:last-child {
            width: 120px;
        }
        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }
        table.table td a.view {
            color: #03A9F4;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #E34724;
        }
        table.table td i {
            font-size: 19px;
        }
    </style>
</head>
<body>
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <form >

                <div class="modal-body">
                    <div class="modal-header">
                        <h4 class="modal-title">Note Detail</h4>
                        <a href="/NoteManagementServlet"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a>
                    </div>
                    <table>
                        <tr>
                            <td>Title : </td>
                            <td>${noteView.title}</td>
                        </tr>
                        <tr>
                            <td>Content : </td>
                            <td>${noteView.content}</td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="${noteView.id}"></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="${noteView.delete_note}"></td>
                        </tr>
                        <tr>
                            <td>Note type : </td>
                            <c:forEach var="noteType" items="${noteTypeList}">
                                <c:if test="${noteView.type_Id == noteType.id_note_type}">
                                    <td><c:out value="${noteType.name_type}"></c:out></td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </table>
<%--                    <div class="form-group">--%>
<%--                        <label>Title</label>--%>
<%--                        <p><c:out value='${noteView.title}'></c:out></p>--%>
<%--&lt;%&ndash;                        <input type="text" name="title" class="form-control" value="<c:out value='${noteEdit.title}'></c:out>">&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Content</label>--%>
<%--                        <p><c:out value='${noteView.content}'></c:out></p>--%>
<%--&lt;%&ndash;                        <input name="content" class="form-control"  value="<c:out value='${noteEdit.content}'></c:out>"></input>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Classify</label>--%>
<%--                        <c:forEach var="noteType" items="${noteTypeList}">--%>
<%--                            <c:if test="${noteView.type_Id == noteType.id_note_type}">--%>
<%--                                <td><c:out value="${noteType.name_type}"/></td>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="modal-footer">
                    <a href="/NoteManagementServlet"><input type="button" class="btn btn-default" data-dismiss="modal" value="Back to List"></a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

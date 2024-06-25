<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h1>Board List</h1>
    <table>
        <thead>
            <tr>
                <th>BNO</th>
                <th>Title</th>
                <th>Content</th>
                <th>Writer</th>
                <th>View Count</th>
                <th>Comment Count</th>
                <th>Reg Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td>${board.bno}</td>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.writer}</td>
                    <td>${board.view_cnt}</td>
                    <td>${board.comment_cnt}</td>
                    <td>${board.reg_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
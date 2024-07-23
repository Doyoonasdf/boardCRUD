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
    <h1>게시판 목록</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>글 제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board_info" items="${boardList}">
                <tr>
                    <td>${board_info.bno}</td>
                    <td>
                    <a href="/board/board/read?IDX=${board_info.bno}">
                    ${board_info.title}
                    </a>
                    </td>
                    <td>${board_info.writer}</td>
                    <td>${board_info.view_cnt}</td>
                    <td>${board_info.reg_date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <button onclick = "location.href ='/board/board/write'">글쓰기</button>
</body>
</html>
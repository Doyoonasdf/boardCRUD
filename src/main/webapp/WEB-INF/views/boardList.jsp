<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board List</title>
    <style>
        li { 
            list-style: none; 
        }
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
        #paginationBox {
            text-align: center;
        }
        .pagination {
            display: inline-block;
            padding: 0;
            margin: 20px 0;
            list-style: none;
            border-radius: 4px;
        }
        .pagination li {
            display: inline;
        }
        .pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }
        .pagination li a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }
        .pagination li a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
    <script>
        function fn_prev(page, range, rangeSize) {
            var page = ((range - 2) * rangeSize) + 1;
            var range = range - 1;
            var url = "${pageContext.request.contextPath}/board/list?page=" + page + "&range=" + range;
            location.href = url;
            debugger;
            
        }

        function fn_pagination(page, range, rangeSize) {
            var url = "${pageContext.request.contextPath}/board/list?page=" + page + "&range=" + range;
            location.href = url;
        }

        function fn_next(page, range, rangeSize) {
            var page = (range * rangeSize) + 1;
            var range = parseInt(range) + 1;
            var url = "${pageContext.request.contextPath}/board/list?page=" + page + "&range=" + range;
            location.href = url;
            debugger;
        }
    </script>
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

    <button onclick="location.href='/board/board/write'">글쓰기</button>

    <!-- pagination -->
    <div id="paginationBox">
        <ul class="pagination">
            <c:if test="${pagination.prev}">
                <li class="page-item">
                    <a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Prev</a>
                </li>
            </c:if>

            <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
                <li class="page-item ${pagination.page == idx ? 'active' : ''}">
                    <a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">${idx}</a>
                </li>
            </c:forEach>

            <c:if test="${pagination.next}">
                <li class="page-item">
                    <a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
                </li>
            </c:if>
        </ul>
    </div>
</body>
</html>
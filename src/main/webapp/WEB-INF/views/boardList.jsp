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
        
        .empty-message {
		    text-align: center;
		    height: 50px; 
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
        .pagination li.active a{
            background-color: #4caf505e;
            color: white;
            border: 1px solid #4caf505e;
        }
        .pagination li a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
    <script>
    
	    function fn_prev(page, range, rangeSize) {
	        //var prevPage = page - 1; // 이전 페이지는 현재 페이지 - 1
	        var prevPage = parseInt(page) -  parseInt(rangeSize);
	        var prevRange = parseInt(range); 
	        if (prevPage < (range - 1) * rangeSize + 1) {
	            prevRange -= 1; // 페이지 범위를 감소시킴
	        }
	        
	        // 이전 페이지가 1 이상일 때만 이동
	        if (prevPage >= 1) {
	            var url = "${pageContext.request.contextPath}/board/list?page=" + prevPage + "&range=" + prevRange;
	            location.href = url;
	        }
	    }

        function fn_pagination(page, range, rangeSize) {
            var url = "${pageContext.request.contextPath}/board/list?page=" + page + "&range=" + range;
            location.href = url;
        }

        function fn_next(page, range, rangeSize, pageCnt) {

            //var nextPage = parseInt(page) + 10; // 다음 페이지는 현재 페이지 + 1
            var nextPage = parseInt(page) + parseInt(rangeSize); // next 클릭시 11,21,31
            var nextRange = parseInt(range);
            
            if (nextPage > range * rangeSize) {
                nextRange += 1; // 페이지 범위를 증가시킴
            }
            
            // 다음 페이지가 전체 페이지 수를 초과하지 않도록 함
            if (nextPage <= pageCnt) {
                var url = "${pageContext.request.contextPath}/board/list?page=" + nextPage + "&range=" + nextRange;
                location.href = url;
            }

        }
        
        function fn_btnSearch(e){
        	e.preventDefault();
        	var url = "${pageContext.request.contextPath}/board/list";
        	url += "searchType=" + $('#searchType').val();
        	url+= "keyword="+$('#keyword').val();
        	location.href = url;
        	console.log(url);
        }
        
    </script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
    <h1>게시판 목록</h1>
    <form action="/board/board/list" class="search-form" method="get" id="searchFoam" name="search-form">
    	<select class="type-box" name="searchType" id="searchType"  >
       		 <option value="title" ${searchType == 'title' ? 'selected' : ''}>제목만</option>
       		 <option value="writer" ${searchType == 'writer' ? 'selected' : ''}>작성자</option>
    	</select>
		<td colspan="2">
          <input class="inputId" id="keyword"  type="text" name="keyword" placeholder="검색어 입력">
        </td>
		<td>
          <input class="submitBtn" type="submit" name="btnSearch" value="검색하기" onClick="fn_btnSearch(e)" >
		</td>
    </form>
    
    
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
			<c:choose>
			    <c:when test="${empty boardList}">
			        <tr class="empty-message">
			            <td colspan="5">조회된 목록이 없습니다.</td>
			        </tr>
			    </c:when>
			    <c:otherwise>
			        <c:forEach var="board_info" items="${boardList}">
			            <tr>
			                <td>${board_info.bno}</td>
			                <td>
			                    <a href="/board/board/read?IDX=${board_info.bno}&page=${pagination.page}">
			                        ${board_info.title}
			                    </a>
			                </td>
			                <td>${board_info.writer}</td>
			                <td>${board_info.view_cnt}</td>
			                <td>${board_info.reg_date}</td>
			            </tr>
			        </c:forEach>
			    </c:otherwise>
			</c:choose>
        </tbody>
    </table>

    <button onclick="location.href='/board/board/write'">글쓰기</button>

    <!-- pagination -->
    <div id="paginationBox">
        
        	<c:out value="${pagination.prev}" />
			<c:out value="${pagination.next}" />
			<c:out value="${pagination.startPage}"/>
			<c:out value="${pagination.endPage}"/>
			<c:out value="${pagination.pageCnt}"/>
    
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
                    <a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}','${pagination.pageCnt}')">Next</a>
                </li>
            </c:if>
        </ul>
			  <input class="startPage" type="hidden" value="${pagination.startPage }" >
			  <input class="endPage" type="hidden" value="${pagination.endPage }" >
			  <input class="page" type="hidden" value="${pagination.page }" >

    </div>
</body>
</html>
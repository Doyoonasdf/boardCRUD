<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board Read</title>
    <style>
    </style>
</head>
<body>
    <h1>게시판 조회</h1>
	<div class="container">
		<div>
			<form action="" method="get" >
				<table class="tableRead">
					<tr>
						<td>작성자</td>
						<td>
						${boardList.writer}
						</td>
					</tr>
					
					<tr>
						<td>제목</td>
						<td>
						 ${boardList.title}
						</td>
					</tr>
					
					<tr>
						<td colspan="2">내용</td>
						<td colspan="2">
						 ${boardList.content}
						</td>
					</tr>
				</table>
			</form>
			<button onclick="location.href ='/board/board/list'"> 목록</button>
			<button onclick="location.href ='/board/board/updateForm?IDX=${boardList.bno}'"> 수정</button>
			<button> 삭제</button>
		</div>
	</div>
</body>
</html>
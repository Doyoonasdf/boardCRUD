<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board Update</title>
    <style>
    </style>
</head>
<body>
    <h1>게시판 수정</h1>
	<div class="container">
		<div>
			<form action="/board/board/update" method="post" >
				<input type="hidden" name="bno" value="${boardList.bno}"/>
				<table class="tableUpdate">
					<tr>
						<td>작성자</td>
						<td>
						<input type="text" name="writer" value="${boardList.writer}" />
						</td>
					</tr>
					
					<tr>
						<td>제목</td>
						<td>
						  <input type="text" name="title" value="${boardList.title}" />
						</td>
					</tr>
					
					<tr>
						<td colspan="2">내용</td>
						<td colspan="2">
						<textarea name="content">${boardList.content}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
						</td>
					</tr>
				</table>
				<button type="submit"> 등록왜안돼ㅡㅡ</button>
			</form>
			<button onclick="location.href ='/board/board/list'">목록</button>
			<button> 삭제</button>
		</div>
	</div>
</body>
</html>
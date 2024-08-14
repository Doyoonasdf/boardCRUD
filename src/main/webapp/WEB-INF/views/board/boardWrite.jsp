<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board Write</title>
    <style>
    </style>
</head>
<body>
    <h1>게시판 등록</h1>
	<div class="container">
		<div>
			<form action="/board/board/insert" method="post" >
				<table class="tableWrite">
					<tr>
						<td>작성자</td>
						<td>
						<input type="text" name="writer">
						</td>
					</tr>
					
					<tr>
						<td>제목</td>
						<td>
						<input type="text" name="title">
						</td>
					</tr>
					
					<tr>
						<td colspan="2">내용</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<textarea rows="10" cols="150" name="content"></textarea>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
						</td>
					</tr>
				</table>
			</form>
			<button onclick="location.href ='/board/board/list'"> 목록</button>
		</div>
	</div>
</body>
</html>
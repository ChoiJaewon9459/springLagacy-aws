<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<script src="/blog/resources/js/board.js"></script>
</head>
<body>
<form id='boardForm' action='/blog/board/update' method='post'>
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>작성자</td>
	</tr>
	<tr>
		<td><input type='hidden' value='${board.boardId}' name='boardId'>${board.boardId}</td>
		<td><input type='text' value='${board.title}' name='title' readonly='readonly'></td>
		<td><input type='text' value='${board.content}' name='content' readonly='readonly'></td>
		<td>${board.userId}</td>
	</tr>
</table>
</form>

<button onclick="location.href='/blog/board'">목록</button>
<span class="updateButton"><button onclick="updateState()">수정</button></span>
<button onclick="location.href='/blog/board/delete/${board.boardId}'">삭제</button>
</body>
</html>
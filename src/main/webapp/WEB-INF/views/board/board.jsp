<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
	</tr>
<c:forEach var="item" items="${boardList}">
	<tr>
		<td>${item.boardId}</td>
		<td><a href="/blog/board/${item.boardId}">${item.title}</a></td>
		<td>${item.userId}</td>
	</tr>
</c:forEach>
</table>
<button onclick="location.href='/blog/board/createForm'">글쓰기</button>
</body>
</html>
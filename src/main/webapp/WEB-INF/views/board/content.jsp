<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.michiget.beans.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-BoardList</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<c:forEach items="${boardContentList }" var="boardContentList">
			<tbody >
				<tr>
					<td>${boardContentList.idx }</td>
					<td>${boardContentList.title }</td>
					<td>${boardContentList.content }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

	<p>
		<a href="/michiget/write">글쓰기</a>
	</p>
	<p>
		<a href="/michiget/list">회원리스트</a>
	</p>
	<p>
		<a href="/michiget/board">게시글리스트</a>
	</p>
	<p>
		<a href="/michiget/logout">로그아웃</a>
	</p>
</body>
</html>
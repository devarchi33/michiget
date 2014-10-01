<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.michiget.beans.UserInfo"%>
<%@ page session="true"%>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	if (userInfo != null)
		System.out.println("home.jsp : Session ok!! now Board-List ");
	else
		System.out.println("home.jsp : Session invalidated!!");
%>

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
	<p><%=userInfo.getNick()%>님으로 로그인 하셨습니다.
	</p>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<c:forEach items="${boardList }" var="boardList">
			<tr>
				<td>${boardList.idx }</td>

				<td><a href="content?idx=${boardList.idx }">${boardList.title }</a></td>

				<td>${boardList.writer }</td>
				<td>${boardList.count }</td>
				<td>${boardList.regdate }</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="/michiget/write">글쓰기</a>
	</p>
	<p>
		<a href="/michiget/list">회원리스트</a>
	</p>
	<p>
		<a href="/michiget/logout">로그아웃</a>
	</p>
	<p>
		<a href="/michiget/content?idx=84">content --- 테스트용(사용안함)</a>
	</p>
</body>
</html>
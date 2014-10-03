<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 리스트의 사이즈 조사를 위한 태그 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 소수점처리 위한 태그 -->

<%@ page import="com.michiget.beans.UserInfo"%>
<%@ page session="true"%>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	String loginId = session.getAttribute("loginId").toString();
	if (userInfo != null && loginId != null)
		System.out.println("board.jsp : Session ok!!");
	else
		System.out.println("board.jsp : Session invalidated!!");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-BoardList</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<!-- <style type="text/css">

</style>  -->
</head>
<body>
	<p><%=loginId%>님으로 로그인 하셨습니다.
	</p>
	<table class="table table-bordered table-hover">
		<thead>
			<tr class="danger">
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<c:forEach items="${boardList }" var="boardList">
			<tbody>
				<tr>
					<td>${boardList.idx }</td>
					<td class="success"><a
						href="content?title=${boardList.title }">${boardList.title}</a></td>
					<!-- /article/list.ok?communityId=${article.communityId}-->
					<td>${boardList.writer }</td>
					<td>${boardList.count }</td>
					<td>${boardList.regdate }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

	<c:if test="${page > 0}">
		<a href="/michiget/board?page=${page-8}">이전페이지</a>
	</c:if>
	<c:if test="${page == 0}">
		<a href="#">이전페이지</a>
	</c:if>
	
	<fmt:parseNumber value="${page/8+1 }" type="number" integerOnly="True" />페이지
	
	<c:if test="${fn:length( boardList ) < 8}">
		<a href="#">다음페이지</a>
	</c:if>
	<c:if test="${fn:length( boardList ) == 8}">
		<a href="/michiget/board?page=${page+8}">다음페이지</a>
	</c:if>

	<ul>
		<li><a href="/michiget/write">글쓰기</a></li>
		<li><a href="/michiget/list">회원리스트</a></li>
		<li><a href="/michiget/logout">로그아웃</a></li>
		<li><a href="/michiget/content?idx=84">content --- 테스트용(사용안함)</a></li>
	</ul>

</body>
</html>
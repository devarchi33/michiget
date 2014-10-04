<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.michiget.beans.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.michiget.beans.UserInfo"%>
<%@ page session="true"%>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	String loginId = session.getAttribute("loginId").toString();
	if (userInfo != null && loginId != null)
		System.out.println("content.jsp : Session ok!!");
	else
		System.out.println("content.jsp : Session invalidated!!");
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
<!-- formChech 자바스크립트 -->
<script type="text/javascript" src="resources/js/formCheck.js"></script>

</head>
<body>
	<!-- wrap -->
	<div class="wrap">
		<!-- header -->
		<div id="header">
			<ul id="menu" class="breadcrumb">
				<li><a href="/michiget/join">회원가입</a></li>
				<li><a href="/michiget/logout">로그아웃</a></li>
			</ul>

			<div class="page-header">
				<c:forEach items="${boardContentList }" var="boardContentList">
					<h1>
						제목 : "${boardContentList.title }" 상세보기&nbsp;&nbsp;<small>현재
							"<%=loginId%>"님으로 로그인 하셨습니다.
						</small>
					</h1>
				</c:forEach>
			</div>

			<ul class="nav nav-pills nav-justified navbar-static-top">
				<li><a href="/michiget/list">회원리스트</a></li>
				<li class="active"><a href="/michiget/board">게시글리스트</a></li>
				<li><a href="/michiget/list">직원리스트</a></li>
				<li><a href="/michiget/list">부서리스트</a></li>
				<li><a href="/michiget/list">급여등급리스트</a></li>
			</ul>
		</div>
		<!-- header end -->
		<!-- container -->
		<div id="container">
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="danger">
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
					</tr>
				</thead>
				<c:forEach items="${boardContentList }" var="boardContentList">
					<tbody>
						<tr class="success">
							<td>${boardContentList.idx }</td>
							<td>${boardContentList.title }</td>
							<td>${boardContentList.content }</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<div class="btn-group">
				<c:forEach items="${boardContentList }" var="boardContentList">
					<ul class="breadcrumb">
						<li><a class="btn btn-primary" href="/michiget/write">글쓰기</a></li>
						<li><a class="btn btn-primary"
							href="/michiget/contentDelete?idx=${boardContentList.idx }">삭제하기</a></li>
					</ul>
				</c:forEach>
			</div>
		</div>
		<!-- container end -->
		<!-- footer -->
		<div id="footer">
			<address>Copyright ⓒ 2014 Iruentech All rights reserved</address>
		</div>
		<!-- footer end-->

	</div>
	<!-- wrap end -->
</body>
</html>
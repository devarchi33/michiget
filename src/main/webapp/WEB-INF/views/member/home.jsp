<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.michiget.beans.UserInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	//String loginId = session.getAttribute("loginId").toString();
	//System.out.println(loginId);
	if (userInfo != null)
		System.out.println("home.jsp : Session ok!!");
	else
		System.out.println("home.jsp : Session invalidated!!");
%>
<html>
<head>
<title>Spring-Board</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
<!-- home CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css" />

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<!-- formChech 자바스크립트 -->
<script type="text/javascript" src="resources/js/formCheck.js"></script>

</head>
<body>
	<!-- wrap -->
	<div id="wrap">
		<c:if test="${check == 1 || check == 2}">
			<script>
				logCheck("${check}");
			</script>
		</c:if>
		<c:choose>
			<c:when test="${check == 0 }">
				<div class="jumbotron">
					<div class="container">
						<h1>
							Hello,"<%=userInfo.getId()%>"
						</h1>
						<p>Login Success!!</p>
						<form action="/michiget/logout" method="get"
							onsubmit="return logout();">
							<ul>
								<li><input class="btn btn-primary" type="submit"
									value="로그아웃" /></li>
								<li><a class="btn btn-primary" href="/michiget/join">회원가입</a></li>
								<li><a class="btn btn-primary" href="/michiget/list">회원리스트</a></li>
								<li><a class="btn btn-primary" href="/michiget/board">게시글리스트</a></li>
							</ul>
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>

				<div class="jumbotron">
					<div class="container">
						<h1>Hello, everybody!</h1>
						<p>This is a sample application.</p>
						<form action="/michiget/login" method="POST"
							onsubmit="return formCheck();">
							<table>

								<tr>
									<th>
										<div class="input-group">
											<span class="input-group-addon">@</span> <input
												class="form-control" placeholder="Username" type="text"
												name="id" size="20">
										</div>
									</th>
								</tr>
								<tr>
									<th>
										<div class="input-group">
											<span class="input-group-addon">@</span> <input
												class="form-control" placeholder="Password" size="20"
												name="pass" type="password">
										</div>
									</th>
								</tr>

							</table>
							<ul>
								<li><input class="btn btn-primary btn-lg" type="submit"
									value="로그인" /></li>
								<li><a class="btn btn-primary btn-lg" href="/michiget/join">회원가입</a></li>

							</ul>
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- wrap end -->
</body>
</html>

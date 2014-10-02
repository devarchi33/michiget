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
<style type="text/css">
button {
	width: 70px;
	height: 30px;
}

table, ul {
	margin: auto;
}

table {
	margin-top: 100px;
}

ul {
	width: 150px;
	height: 150px;
	list-style: none;
	margin-top: 10px;
}

li {
	margin-top: 5px;
}
</style>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<script>
	function formCheck() {
		var id = document.forms[0].id;
		var pass = document.forms[0].pass;

		if (id.value == null || id.value == "") {
			alert('아이디를 입력하세요');
			document.forms[0].id.focus();
			return false;
		}

		if (pass.value == null || pass.value == "") {
			alert('비밀번호를 입력하세요');
			document.forms[0].pass.focus();
			return false;
		}

	}
	function logCheck(check) {
		if (check == 1) {
			alert('존재하지 않는 아이디 입니다.');
			return false;
		}
		if (check == 2) {
			alert('비밀번호가 틀렸습니다.');
			return false;
		}
	}
	function logout() {
		alert("이용해주셔서 감사합니다.");
	}
</script>
</head>
<body>

	<c:if test="${check == 1 || check == 2}">
		<script>
			logCheck("${check}");
		</script>
	</c:if>
	<c:choose>
		<c:when test="${check == 0 }">

			<form action="/michiget/logout" method="get"
				onsubmit="return logout();">
				<table>

					<tr>
						<td><%=userInfo.getId()%>님, 환영합니다.</td>
					</tr>

				</table>

				<ul>
					<li><button class="btn btn-primary btn-xs" type="submit"
							value="로그아웃">로그아웃</button></li>
					<li><a href="/michiget/join">회원가입</a></li>
					<li><a href="/michiget/list">회원리스트</a></li>
					<li><a href="/michiget/board">게시글리스트</a></li>
				</ul>
			</form>



		</c:when>
		<c:otherwise>

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
					<li><button class="btn btn-primary btn-xs" type="submit"
							value="로그인">로그인</button></li>
					<li><a href="/michiget/join">회원가입</a></li>

				</ul>
			</form>


		</c:otherwise>
	</c:choose>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ page import="com.michiget.beans.UserInfo"%>
<%@ page session="true"%>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
	String loginId = userInfo.getId();
	if (userInfo != null && loginId != null)
		System.out.println("home.jsp : Session ok!! now Board-write");
	else
		System.out.println("home.jsp : Session invalidated!!");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Donghoon's Model1 Board - Text_Input_Form</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
<!-- form CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/form.css" />
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<script>
	function formCheck() {

		var title = document.forms[0].title.value; // 사용하기 쉽도록 변수를 선언하여 담아주고,
		var writer = document.forms[0].writer.value;
		//var regdate = document.forms[0].regdate.value;
		//var content = document.forms[0].content.value;   

		if (title == null || title == "") { // null인지 비교한 뒤
			alert('제목을 입력하세요'); // 경고창을 띄우고
			document.forms[0].title.focus(); // 해당태그에 포커스를 준뒤
			return false; // false를 리턴합니다.
		}

		if (writer == null || writer == "") {
			alert('작성자를 입력하세요');
			document.forms[0].writer.focus();
			return false;
		} /*else if (writer.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null) {
																			alert('이메일 형식으로 입력하세요');
																			document.forms[0].writer.focus();
																			return false;
																		}*/

	} // function end
</script>
</head>
<body>
	<!-- wrap -->
	<div id="wrap">
		<!-- header -->
		<div id="header">
			<ul id="menu" class="breadcrumb">
				<li><a href="/michiget/board">목록보기</a></li>
				<li><a href="/michiget/logout">로그아웃</a></li>
			</ul>

			<div class="page-header">
				<h1>
					글쓰기&nbsp;&nbsp;<small>현재 "<%=loginId%>"님으로 로그인 하셨습니다.
					</small>
				</h1>
			</div>
		</div>
		<!-- headr end -->
		<!-- container -->
		<div id="container">
			<form action="/michiget/board" name="boardWrite" method="POST"
				onsubmit="return formCheck();">
				<div class="row">
					<div class="form-froup col-lg-2">
						<label for="제목">제목</label> <input type="text" class="form-control"
							placeholder="title" name="title">
					</div>
				</div>
				<div class="row">
					<div class="form-froup col-lg-2">
						<label for="작성자">작성자</label> <input type="text"
							class="form-control" placeholder="writer" name="writer">
					</div>
				</div>
				<div class="row">
					<div class="form-froup col-lg-2">
						<label for="내용">내용</label>
						<textarea name="content" class="form-control"
							placeholder="content" rows="10"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-2">
						<button type="submit" class="btn btn-primary">제출</button>
					</div>
				</div>
			</form>
		</div>
		<!-- container end-->
		<!-- footer -->
		<div id="footer"></div>
		<!-- footer end -->
	</div>
	<!-- wrap end -->
</body>
</html>




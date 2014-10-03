<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Join</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
 
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
<script>
	function joinFormCheck() {
		var id = document.joinForm.id;

		if (id.value == null || id.value == "") {
			alert('아이디를 입력하시오');
			document.joinForm.id.focus();
			return false;
		}
	}
	function mail_sel() {

		var sel = document.joinForm.email3;
		document.joinForm.email2.value = sel.value;
		if (sel.selectedIndex == 0) {
			document.joinForm.email2.focus();
		}
		return;
	}
</script>
</head>
<body>
	<form action="/michiget/member" name="joinForm" method="POST"
		onsubmit="return joinFormCheck();">
		<table>
			<caption>글쓰기</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<th>대화명</th>
				<td><input type="text" size="" name="nick" /></td>
			</tr>

			<!-- <tr height="50">
					<th>핸드폰번호</th>
					<td>&nbsp&nbsp<select name="ph1">
							<option value="010" selected>010</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>&nbsp- <input type="text" size="5" name="ph2" />&nbsp-&nbsp<input
						type="text" size="5" name="ph3" />
					</td>
				</tr> -->
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="남자"
					checked="checked" />남자 <input type="radio" name="gender"
					value="여자" />여자</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>&nbsp;&nbsp;<input type="text" name="email1" />@
					<input type="text" name="email2" />&nbsp; <select
					name="email3" onchange="mail_sel()">
						<option value="">직접입력</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
				</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="가입하기" />&nbsp;&nbsp; <input type="reset"
			value="다시하기" />
	</form>
	
	<p><a href="/michiget/logout">홈</a></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
		//var idx = sel.selectedIndex;
		document.joinForm.email2.value = sel.value;
		if (sel.selectedIndex == 0) {
			document.joinForm.email2.focus();
		}
		return;
	}
</script>
</head>
<body>
	<form action="/michiget/member" name="joinForm" method="GET"
		enctype="multipart/form-data" onsubmit="return joinFormCheck();">
		<table border="1" cellspacing="0" width="500" height="400"
			align="center">
			<caption>글쓰기</caption>
			<tr height="50">
				<th width="120">아이디</th>
				<td>&nbsp&nbsp<input type="text" name="id" /></td>
			</tr>
			<tr height="50">
				<th width="120">비밀번호</th>
				<td>&nbsp&nbsp<input type="password" name="pass" /></td>
			</tr>
			<tr height="50">
				<th width="120">대화명</th>
				<td>&nbsp&nbsp<input type="text" size="" name="nick" /></td>
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
			<tr height="50">
				<th>성별</th>
				<td>&nbsp&nbsp<input type="radio" name="gender" value="남자"
					checked="checked" />남자 <input type="radio" name="gender"
					value="여자" />여자
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>&nbsp;&nbsp;<input type="text" size="15" name="email1" />@
				<input type="text" size="15" name="email2" />&nbsp;
					<select	name="email3" onchange="mail_sel()">
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
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-MemberList</title>
</head>
<body>
	<table border="1">
	<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>			
				<th>대화명</th>			
				<th>성별</th>
				<th>이메일</th>
				<th>ip</th>
				<th>가입일</th>
			</tr>
		</thead> 
		<c:forEach items="${userList }" var="userList">
				<tr>
					<td>${userList.idx }</td>
					<td>${userList.id }</td>
					<td>${userList.nick } </td>
					<td>${userList.gender }</td>
					<td>${userList.email1 }@${userList.email2 }</td>
					<td>${userList.regIp }</td>
					<td>${userList.regDate }</td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>
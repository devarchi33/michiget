<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<%
	session.invalidate();
%>
<html>
<head>
<title>Spring-Logout</title>
</head>
<body>
	<script>
		location.replace("/michiget");
	</script>
</body>
</html>

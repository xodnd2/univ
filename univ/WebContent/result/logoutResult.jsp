<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
text-align: center;
}
</style>
</head>
<body>
	<h2>${id } : logout!!!</h2>
	<%
		session.invalidate();
	%>
	<%@ include file = "home.jsp"%>
</body>
</html>
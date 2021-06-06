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
	<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null)
	{ %>
		<h2>${msg }</h2>
	<%} else
	{
		out.print("<h2>Enroll Subject Success!!</h2>");
	}
	%>
	<%@ include file = "proMenuButton.jsp"%>
</body>
</html>
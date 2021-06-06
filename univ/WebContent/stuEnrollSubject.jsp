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
	<form action="search.do" method = "post">
		Subject ID: <input type = "text" name = "sId" required>
		<input type = "submit" value ="Search">
	</form>
<%
	String title = (String)request.getAttribute("title");
	String msg = (String)request.getAttribute("msg");
	if(msg != null && msg.equals("Success")){
	%>
		<form action="stuEnrollSubject.do" method="post">
			Title :<input type="text" readonly name="title" value="${title }">
			<input type = "submit" value = "Enroll">
		</form>
	<%} else if(msg != null && msg.equals("Fail")){
		out.print("Subject doesn't exist.");
	}
%>
<%@ include file = "/result/stuMenuButton.jsp"%>
</body>
</html>
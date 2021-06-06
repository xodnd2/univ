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
<h1>Enroll Subject</h1>
<form action="proEnrollSubject.do" method = "post">
	Subject ID : <input type = "text" name ="sId" required><br>
	Subject Title : <input type = "text" name ="title" required><br>
	# of Student : <input type = "text" name ="stuNum" required><br>
	<input type = "submit" value = "Enroll">
<%@ include file = "/result/proMenuButton.jsp"%>
</form>
</body>
</html>
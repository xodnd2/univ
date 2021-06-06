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
<h1>YongIn LMS</h1>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null && msg.equals("RS"))
{%>
	<script type="text/javascript">alert("Register Success!");</script>
<%} else if(msg != null && msg.equals("RF"))
{%>
	<script type="text/javascript">alert("Register Fail!");</script>
<%} else if(msg != null && msg.equals("LF"))
{%>
<script type="text/javascript">alert("Login Fail!");</script>
<%}
%> 
<fieldset>
<legend>Login</legend>
<form action="login.do" method = "post">
	ID : <input type = "text" name = "id" required><br>
	Password : <input type = "password" name = "pwd" required><br>
	<input type="radio" id="professor" name="pos" value = "professor" required>
	<label for="professor">Professor</label>
	<input type="radio" id="student" name="pos" value = "student" required>
	<label for="student">Student</label><br>
	<input type = "submit" value = "Login">
	Or <a href = "register.jsp">Register</a>
</form>
</fieldset>
</body>
</html>
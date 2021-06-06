<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
text-align: center;
}
</style>
</head>
<body>
<h1>YongIn LMS</h1>
<fieldset>
	<legend>Register</legend>
	<form action="register.do" method = "post">
		ID : <input type = "text" name = "id" required><br>
		Password : <input type = "password" name = "pwd" required><br>
		Name : <input type = "text" name = "name" required><br>
		<input type="radio" id="professor" name="pos" value = "professor" required>
		<label for="professor">Professor</label>
		<input type="radio" id="student" name="pos" value = "student" required>
		<label for="student">Student</label><br>
		<input type = "submit" value = "Register">
		Or <a href = "login.jsp">Login</a>
	</form>
</fieldset>
</body>
</html>
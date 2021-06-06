<%@page import="univ.vo.Subject"%>
<%@page import="java.util.ArrayList"%>
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
margin : 0 auto;
}
</style>
</head>
<body>
<h1>${id }님이 등록한 과목들</h1>
	<%
	ArrayList<Subject> stuSubjects = (ArrayList<Subject>)request.getAttribute("stuSubjects");
			if(!stuSubjects.isEmpty())
			{
	%>
			<table border = "1">
				<tr><th>과목번호</th><th>과목명</th><th>취소</th></tr>
		<%
		for(int i=0; i < stuSubjects.size(); i++)
			{
				Subject stuSubject = stuSubjects.get(i);
		%>
				<tr><td><%=stuSubject.getSId() %></td>
					<td><%=stuSubject.getSName() %></td>
					<td><a href="cancelSubject.do?sId=<%=stuSubject.getSId()%>">취소</a></td>
				</tr>
		<%
			}
		}
		%></table>
<%@ include file = "stuMenuButton.jsp"%>
</body>
</html>
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
<h1>${id }교수님이 등록하신 과목들</h1>
	<%
	ArrayList<Subject> proSubjects = (ArrayList<Subject>)request.getAttribute("proSubjects");
			if(!proSubjects.isEmpty())
			{
	%>
			<table border = "1">
				<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th><th>삭제</th></tr>
		<%
		for(int i=0; i < proSubjects.size(); i++)
			{
				Subject proSubject = proSubjects.get(i);
		%>
				<tr><td><a href = "proShowSubject2.do?sId=<%=proSubject.getSId()%>
				&sName=<%=proSubject.getSName()%>&cN=<%=proSubject.getCountNow() %>">
				<%=proSubject.getSId() %></a></td>
					<td><%=proSubject.getSName() %></td>
					<td><%=proSubject.getCount() %></td>
					<td><%=proSubject.getCountNow() %></td>
					<td><a href="removeSubject.do?sId=<%=proSubject.getSId()%>">삭제</a></td>
				</tr>
		<%
			}
		}
		%></table>
<%@ include file = "proMenuButton.jsp"%>
</body>
</html>
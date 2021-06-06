<%@page import="univ.vo.ProSubjectStu"%>
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
<h1>${sName}/ 총 수강인원: ${cN}</h1>
<%
		ArrayList<ProSubjectStu> proSubjectStus 
		= (ArrayList<ProSubjectStu>)request.getAttribute("proSubjectStus");
		if(!proSubjectStus.isEmpty())
		{%>
			<table border = "1">
				<tr><th>id</th><th>이름</th>
		<%
			for(int i=0; i < proSubjectStus.size(); i++)
			{
				ProSubjectStu proSubjectStu = proSubjectStus.get(i); %>
				<tr><td><%=proSubjectStu.getId() %></td>
					<td><%=proSubjectStu.getName() %></td>
				</tr>
		<%
			}
		}
		%></table>
<%@ include file = "proMenuButton.jsp"%>
/<a href = "proShowSubject.do">back</a>
</body>
</html>
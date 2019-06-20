<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id"); 
	String name = request.getParameter("name");
	String nickname = request.getParameter("nickname");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입을 환영합니다!</h1>

"<%=nickname %>" <%=name %>(<b><%=id %></b>)님! 가입해주셔서 감사합니다!  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ex.bbs.MemberVO"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입을 환영합니다!</h1>

"${memberVO.nick }" ${memberVO.name }(<b>${memberVO.id }</b>)님! 
<br>
가입해주셔서 감사합니다!  
<br><hr><br>
<a href="login.jsp">로그인</a>
</body>
</html>
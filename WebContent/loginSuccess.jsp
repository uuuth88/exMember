<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ex.bbs.MemberVO"%>
<% 
	request.setCharacterEncoding("utf-8");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공!</h1>
<br><hr><br>
<p>아이디 : ${loginMember.id }</p>
<p>이름 : ${loginMember.name }</p>
<p>닉네임 : ${loginMember.nick }</p>
<br><hr><br>
<a href="list">회원목록</a>
<br><br>
<a href="modify.jsp?id=${loginMember.id }">수정</a>
<a href="delete">탈퇴</a>
</body>
</html>
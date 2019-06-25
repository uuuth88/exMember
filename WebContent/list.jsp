<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ex.bbs.MemberVO"%>
<%
	List<MemberVO> memberlist = (List<MemberVO>)request.getAttribute("memberlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td colspan="2">회원 목록</td>
	</tr>
<%
for(MemberVO member : memberlist){
%>	
	<tr>
		<td>아이디 : </td>
		<td><%=member.getId() %></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><%=member.getName() %></td>
	</tr>
	<tr>
		<td>닉네임 : </td>
		<td><%=member.getNick() %></td>
	</tr>
<%
}
%>	
</table>
</body>
</html>
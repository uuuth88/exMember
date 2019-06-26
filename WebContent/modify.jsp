<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입창</title>
<style>
	table{
		width : 50%;
		height : 400px;
		margin : 0px auto;
	}
	table,td{
		border : 1px solid black;
		border-collapse: collapse;
	}
	td{
		padding : 10px;
		text-align : center;
	}
	input{
		padding : 5px 30px;
	}
	#btn{
		font-size : 15px;
	}
</style>
</head>
<body>
<form action="join" method="post">
<table>
    <tr>
        <td colspan="3">회원수정 폼</td>
    </tr>
    <tr>
        <td>아이디</td>
        <td><input type="text" name="id"></td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><input type="password" name="pw"></td>
    </tr>
    <tr>
        <td>이름</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>별명</td>
        <td><input type="text" name="nickname"></td>
    </tr>
    <tr>
        <td colspan="3">
            <input type="submit" value="수정하기" id="btn">
        </td>
    </tr>
</table>
</form>
</body>
</html>
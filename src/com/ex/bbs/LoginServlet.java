package com.ex.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		1.로그인한 아이디를 받아와서 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		2.dao.login()메소드는 MemberVO객체를 반환한다.
//		그 결과값을 받아와 저장하기 위해 우선 MemberVO객체를 만들고
//		dao.login(id)의 반환 객체를 member에 저장
		MemberVO member = new MemberVO();
		MemberDAO dao = new MemberDAO();
		member = dao.login(id, pw);
//		3.loginMember 이름으로 저장 후 바인딩
		request.setAttribute("loginMember", member);
//		4.loginSuccess.jsp로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
		rd.forward(request, response);
	}
}

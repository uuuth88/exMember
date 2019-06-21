package com.ex.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. join.jsp에서 넘어온 데이터들을 알맞은 변수에 담는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nick = request.getParameter("nickname");

		//2. MemberVO 객체를 생성해 저장한다.
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setNick(nick);
		
		//3. MemberDAO 객체를 생성한 후 add()메소드를 호출해
		//회원 정보를 저장한다.
		MemberDAO dao = new MemberDAO();
		dao.add(vo);
		
		//4. 작업을 마치면 joinSuccess.jsp로 포워딩.
		RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
		rd.forward(request, response);
	}

}

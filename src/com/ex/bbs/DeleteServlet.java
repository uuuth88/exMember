package com.ex.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		세션에 담은 로그인한 회원 정보를 가져온다		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("loginMember");
		
//		회원의 id를 변수에 담은 후		
		String id = member.getId();

//		dao.delete()메소드의 인자값으로 활용한다		
		MemberDAO dao = new MemberDAO();
		dao.delete(id);
		
//		모든 작업을 마친 후 deleteDone페이지로 포워딩		
		RequestDispatcher rd = request.getRequestDispatcher("deleteDone.jsp");
		rd.forward(request, response);
	}
}

package com.ex.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
//	회원 정보를 수정할 때 생각할 점이 있다. 바로 요청이 변경 될 때마다 request 객체가 가지는 스코프 범위가 리셋되는데
//	이런 한계를 극복하기 위해 session객체에 회원 정보를 담을 것이다. 회원수정 페이지에서 session객체에 담긴 정보를 가져올 것이고
//  거기서 수정할 정보를 가져와서 DB에 연결시키도록 하자.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");

//		modify.jsp에서 입력한 데이터들을 변수에 담아 DAO에서 활용할 수 있도록 한다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nickname");
		
//		DAO를 호출한 후 회원정보를 수정하는 작업을 수행한다.
		MemberDAO dao = new MemberDAO();
		dao.modify(id, pw, nick);
		
//		모든 작업이 끝난 후 login페이지로 포워딩 시켜 로그인 후 회원 정보를 확인하도록 한다.		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}

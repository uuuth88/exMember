package com.ex.bbs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	//1. 회원 등록하는 메소드
	public void add(MemberVO vo) {
		try {
			//DB와 연결시켜줄 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DB 연결 설정
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
											   "exLogin", 
											   "exLogin");
			//회원 정보를 저장할 SQL문 작성
			String sql = "INSERT INTO memberInfo(id, pw, name, nickname) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			//MemberVO 객체에서 getter메소드를 이용해 회원 정보를 가져온 후 pstmt 객체에 저장
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	로그인 메소드
	public MemberVO login(String id, String pw) {
//		로그인 정보를 담을 MemberVO객체 생성
		MemberVO member = new MemberVO();
		ResultSet rs = null;
		try {
//			JDBC과정			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
											   "exLogin", 
											   "exLogin");
			String sql = "select id, name, nickname from memberInfo where id=? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
//			ResultSet객체에 쿼리문 조회 결과를 저장
			rs = pstmt.executeQuery();
//			rs에 저장한 데이터가 있다면 MemberVO 객체에 저장
			if(rs.next()) {
				member.setId(rs.getString("id"));
				//rs엔 pw값은 저장되지 않는다 쿼리문 조회는 id, name, nickname만..
				//member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setNick(rs.getString("nickname"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs!=null){rs.close();}}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null){pstmt.close();}}catch(Exception e){e.printStackTrace();}
			try {if(conn!=null){conn.close();}}catch(Exception e){e.printStackTrace();}
		}
		
		return member;
	}
	
//	리스트 메소드
	public List<MemberVO> list(){
//		멤버 정보 담을 리스트 객체 생성
		List<MemberVO> list = new ArrayList<>();
//		여기에 Member객체 생성하지 않도록 조심!!!
//		MemberVO member = new MemberVO();
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
											   "exLogin", 
											   "exLogin");
			String sql = "select * from memberInfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				Member객체 생성 위치에 주의하자 만약 try구문 밖에
//				생성한다면 가장 최근에 저장된 Member객체 하나만 계속 돌려쓴다.
//				즉, rs테이블을 하나하나 검색해 가면서 member객체를 채워넣어야 하는데
//				커서가 다음 내용으로 넘어가면 새로운 객체를 생성하지 않고
//				구문 밖에서 선언한 member객체를 다시 불러와 그전에 저장한 정보 위에
//				덮어쓰기를 하게 되어 리스트를 호출할 때 같은 회원만 불러오게 된다.
//				내가 그런 오류를 겪어서 쓰는 말!				
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setNick(rs.getString("nickname"));
				list.add(member);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs!=null){rs.close();}}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null){pstmt.close();}}catch(Exception e){e.printStackTrace();}
			try {if(conn!=null){conn.close();}}catch(Exception e){e.printStackTrace();}
		}
		return list;
	}

//	회원 정보 수정하는 메소드
	public void modify(String id, String pw, String nick) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
												"exLogin", 
												"exLogin");
			String sql = "UPDATE memberInfo SET pw=?, nickname=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, nick);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null){pstmt.close();}}catch(Exception e){e.printStackTrace();}
			try {if(conn!=null){conn.close();}}catch(Exception e){e.printStackTrace();}
		}
	}
	
//	회원 탈퇴하는 메소드
	public void delete(String id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
												"exLogin", 
												"exLogin");
			String sql = "DELETE FROM memberInfo where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null){pstmt.close();}}catch(Exception e){e.printStackTrace();}
			try {if(conn!=null){conn.close();}}catch(Exception e){e.printStackTrace();}
		}
	}
}

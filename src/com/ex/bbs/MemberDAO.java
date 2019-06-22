package com.ex.bbs;

import java.sql.*;

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
	
	public MemberVO login(String id) {
		MemberVO member = new MemberVO();
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
											   "exLogin", 
											   "exLogin");
			String sql = "select id, name, nickname from memberInfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setNick(rs.getString("nickname"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
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
		
		return member;
	}
}

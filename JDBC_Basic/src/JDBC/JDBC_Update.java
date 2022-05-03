package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 id를 입력, 수정할 이름과 이메일도 입력 
		 지목한 id의 이름과 이메일을 새로운 값으로 수정 
		 ID는 존재하는 ID를 넣어주셔야 수정 가능 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요.");
		System.out.println("아이디 : ");
		String id = sc.next();
		
		System.out.println("변경할 이름과 이메일을 입력하세요.");
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("이메일 : ");
		String email = sc.next();
		
		String sql = "Update members SET name  = ? , email= ? WHERE id = ?";
//		sql에 저장한 쿼리문이 그냥 그대로 db에 보내주고 지정한 타입에 맞게 ?에 값이 들어감
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "hr";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			
			int rt = pstmt.executeUpdate();
			
			if (rt>=1) {
				System.out.println("DB에 회원정보 업데이트 성공");
				System.out.println("성공한 쿼리 수 : " + rt);
			}
			else {
				System.out.println("업데이트 실패 ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
			conn.close();
			sc.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}


	}

}

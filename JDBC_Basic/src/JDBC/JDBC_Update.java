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
		 id�� �Է�, ������ �̸��� �̸��ϵ� �Է� 
		 ������ id�� �̸��� �̸����� ���ο� ������ ���� 
		 ID�� �����ϴ� ID�� �־��ּž� ���� ���� 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���̵� �Է��ϼ���.");
		System.out.println("���̵� : ");
		String id = sc.next();
		
		System.out.println("������ �̸��� �̸����� �Է��ϼ���.");
		System.out.println("�̸� : ");
		String name = sc.next();
		
		System.out.println("�̸��� : ");
		String email = sc.next();
		
		String sql = "Update members SET name  = ? , email= ? WHERE id = ?";
//		sql�� ������ �������� �׳� �״�� db�� �����ְ� ������ Ÿ�Կ� �°� ?�� ���� ��
		
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
				System.out.println("DB�� ȸ������ ������Ʈ ����");
				System.out.println("������ ���� �� : " + rt);
			}
			else {
				System.out.println("������Ʈ ���� ");
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

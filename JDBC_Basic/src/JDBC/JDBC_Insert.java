package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class JDBC_Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ȸ������ ������");
		System.out.println("���̵� : ");
		String id = sc.next();
//		id�� ���� �Է¹���
		System.out.println("��й�ȣ : ");
		String pw = sc.next();
		
		System.out.println("�̸� : ");
		String name = sc.next();
		
		System.out.println("�̸��� : ");
		String email = sc.next();
		
		
//		SQL�ۼ�
//		SQL���� String ���·� �ۼ�
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?)";
//		members��� ���̺��� �����ϰ� ���� �־���
//		INSERT�ϰ��� �ϴ� ������ ���� �ڸ��� ?�� ǥ��
		
//		DB���� ����
//		1. DB ����� ������, ��ȣ, DB URL �� �ʱ� ������ ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "hr";
//		Connection ��ü�� ���� 3���� ������ ������ java�� DB����
		
//		����� ��ü�� ������ �̸� ����(finally������ ����ؾ�������)
		Connection conn = null;
		PreparedStatement pstmt = null;
//		JAVA�� DB���� �����ϴ� ������ ����� �ִ� ��
		
		try {
//			���ܰ� �߻��� �� �ִ� code�� ���� �� ���
//		2. JDBC Connector Driver ȣ��
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Ư�� Ŭ���� �������� �޼ҵ��̸� forName�� throws�� �����Ƿ� try catch�ȿ��� ���� 
			
					
//		3. DB������ ���� Ŭ�������� ��ü�� ���� 
			/*
			 - Connection ��ü : DB���� ������ ���� ��ü
			 - Connection ��ü�� new �����ڸ� ���� ���� �����ϴ� ���� �ƴ϶� 
			 - DriverManager Ŭ������ �����ϴ� ���� �޼ҵ��� getConnection()�� ȣ���Ͽ� ��ü�� �޾ƿ�  
			 */
			conn = DriverManager.getConnection(url, uid, upw);
			
			/*
			 PreparedStatement ��ü 
			 - SQL���� �����Ű�� ���� ��ü
			 Pstmt(PreparedStatement) ��ü�� conn ��ü�� �����ϴ� PreparedStatement() �޼��带 ȣ���Ͽ� ��ü�� �޾ƿ� 
			 �Ű������� �����ų sql���� ����
			 */
			pstmt = conn.prepareStatement(sql);
			
			/*
			 SQL�ϼ��ϱ�(������ SQL�� ?�� ä���)
			 - pstmt ��ü�� �����ߴٸ� SQL���� ?�� ä�� �� ����
			 - ?�� ù��° ����ǥ���� 1�� �ε������� ������ ���������� �ε����� 1�� ����
			 - DB ���̺��� �÷� Ÿ�Կ� ���� setString(), setInt() ���� �޼��带 ���� ?�� ä��  
			 */
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
//			ȭ������ �Է¹��� ���� Connection Ŭ������ ���� sql�� �����Ͽ� ���� ���� �־��� �� ����
			
			/*
			 pstmt ��ü�� ���� SQL ���� 
			 - INSERT, UPDATE, DELETE ����� ��쿡�� excuteUpdate()�� ȣ��
			 - SELECT ����� ��� executeQuery()�� ȣ�� 
			 - executeUpdate()�� sql ���� �� ������ �������� ������ ���� �� 0�� ����(�����۵� Ȯ�� ����)
			 */
			int rt = pstmt.executeUpdate();
			
			if (rt >= 1) {
				System.out.println("DB�� ȸ������ ���� ����!");
				System.out.println("������ ���� �� " + rt);
			} else {
				System.out.println("DB�� ȸ������ ���� ����!");
			}

		} catch (Exception e) {
			e.printStackTrace();
//			���ܰ� �߻����� �� �����ִ� ��(������ Ŭ������ ������ ���õ�)
//			� ���ܰ� �߻����� �𸦶����� Exception�� �����ָ� �ǰ� Exception�ȿ� ��κ��� ���ܰ� �ֱ� ����
		} finally {
//			����ó���� �߻� ���ο� ������� �������� ������ ����
			/*
			 DB������ ����� ��ü �ڿ� �ݳ� 
			 - ��Ȱ�� JDBC ����� ���� ����� �ڿ��� �ݳ� (�޸� ��
			 */
//			try�ȿ��� pstmt�� conn�� ��ȿ�ϱ� ������ try��� �ۿ��� ����� ��

			try {
				pstmt.close();
				conn.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
//		Ư�� �����ȿ� OracleDriver��� Ŭ������ ������ �ҷ���
		
	}

}

package JDBC;
import java.util.Scanner;
public class JDBCInsert {

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
		
//		===============================================================
		
//		SQL�ۼ�
//		SQL���� String ���·� �ۼ�
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?)";
//		INSERT�ϰ��� �ϴ� ������ ���� �ڸ��� ?�� ǥ��
		
//		DB���� ����
//		1. DB ����� ������, ��ȣ, DB URL �� �ʱ� ������ ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "hr";
		
//		JAVA�� DB���� �����ϴ� ������ ����� �ִ� ��
		try {
//			���ܰ� �߻��� �� �ִ� code�� ���� �� ���
//		2. JDBC Connector Driver ȣ��
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//		3. DB������ ���� Ŭ�������� ��ü�� ���� 
			/*
			 - Connection ��ü : DB���� ������ ���� ��ü
			 
			 - Connection ��ü�� new �����ڸ� ���� ���� �����ϴ� ���� �ƴ϶� 
			 - DriverManager Ŭ������ �����ϴ� ���� �޼ҵ��� getConnection()�� ��ȣ���Ͽ� ��ü�� �޾ƿ�  
			 */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			���ܰ� �߻����� �� �����ִ� ��(������ Ŭ������ ������ ���õ�)
		}
		
//		Ư�� �����ȿ� OracleDriver��� Ŭ������ ������ �ҷ���
		
	}

}
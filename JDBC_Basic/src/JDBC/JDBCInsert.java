package JDBC;
import java.util.Scanner;
public class JDBCInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("회원가입 페이지");
		System.out.println("아이디 : ");
		String id = sc.next();
//		id를 직접 입력받음
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("이메일 : ");
		String email = sc.next();
		
//		===============================================================
		
//		SQL작성
//		SQL문은 String 형태로 작성
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?)";
//		INSERT하고자 하는 변수의 값의 자리를 ?로 표현
		
//		DB연동 순서
//		1. DB 사용자 계정명, 암호, DB URL 등 초기 데이터 변수 설정
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr";
		String upw = "hr";
		
//		JAVA와 DB간의 연결하는 지점을 만들어 주는 것
		try {
//			예외가 발생할 수 있는 code를 적을 때 사용
//		2. JDBC Connector Driver 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//		3. DB연동을 위한 클래스들의 객체를 생성 
			/*
			 - Connection 객체 : DB와의 연결을 위한 객체
			 
			 - Connection 객체는 new 연산자를 통해 직접 생성하는 것이 아니라 
			 - DriverManager 클래스가 제공하는 정적 메소드인 getConnection()을 ㅌ호출하여 객체를 받아옴  
			 */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			예외가 발생했을 때 보여주는 것(지금은 클래스가 없으면 나올듯)
		}
		
//		특정 폴더안에 OracleDriver라는 클래스를 강제로 불러옴
		
	}

}

package managerhotel.untils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
//	public static void main(String[] args) {
//	openConnect("jdbc:mysql://localhost:3306/fruitfresh", "root", "Thanhcong1");
//	}
	private static String DB_URL = "jdbc:mysql://localhost:3306/fruitfresh";
    private static String USER_NAME = "root";
    private static String PASSWORD = "Thanhcong1";
	
	public static Connection openConnect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

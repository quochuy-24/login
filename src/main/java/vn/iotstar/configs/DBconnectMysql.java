package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectMysql {

	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "Mysqlpwd123@";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/users";

	public static Connection getDatabaseConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
//	public static void main(String args[]) {
//		DBconnectMysql a = new DBconnectMysql();
//		try {
//			System.out.print(a.getDatabaseConnection());
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}

}

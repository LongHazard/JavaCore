package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static void main(String[] args) {
		getConn();
	}
	
	public static Connection getConn() {
		final String username = "root";
		final String password = "20111997";
		
		final String url = "jdbc:mysql://localhost:3306/hello";
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Loi ket noi db");
		}
		return null;
	}

}

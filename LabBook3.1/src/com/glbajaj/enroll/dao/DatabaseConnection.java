package com.glbajaj.enroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rahul","rahul");
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		return con;
	}

}

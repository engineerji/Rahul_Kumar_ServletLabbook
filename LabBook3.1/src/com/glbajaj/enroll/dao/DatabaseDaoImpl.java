package com.glbajaj.enroll.dao;

import java.sql.Connection;

public class DatabaseDaoImpl implements DatabaseDao{
	static Connection con;
	public Connection getConnection(){
		con=DatabaseConnection.getConnection();
		return con;
	}

}

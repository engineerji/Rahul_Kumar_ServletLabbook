package com.glbajaj.enroll.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.glbajaj.enroll.dao.DatabaseDaoImpl;

public class ServiceClass {
	ServiceClass serve;
	private ServiceClass() {
		serve=new ServiceClass();
	}
	public static ResultSet getData() {
		Connection con=new DatabaseDaoImpl().getConnection();
		ResultSet rs=null;
		try {
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery("select * from trainings");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}

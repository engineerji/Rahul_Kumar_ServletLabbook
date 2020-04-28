package com.glbajaj.enroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glbajaj.enroll.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class EnrollServlet
 */
public class EnrollServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Connection con=new DatabaseDaoImpl().getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from trainings");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>Training Id</th>"); 
			out.print("<th>Training Name</th>"); 
			out.print("<th>Avalaible Seats</th>"); 
			out.print("</tr>");
			while(rs.next()) { 
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td><a href='ResponseServlet?id="+rs.getInt(1)+"&tname="+rs.getString(2)+"&seats="+rs.getInt(3)+"'>Enroll</a></td>"); 
				out.print("</tr>");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

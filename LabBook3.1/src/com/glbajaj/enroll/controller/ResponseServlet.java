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
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String tname=req.getParameter("tname");
		int seat=Integer.parseInt(req.getParameter("seats"));
		PrintWriter out = resp.getWriter();
		if(seat==0) {
			out.print("<b>No Seats Are Available.</b>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
		else{
			try {
				
				Connection con=new DatabaseDaoImpl().getConnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("update trainings set availableseats="+(seat-1)+" where trainingid="+id);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("<b>Hi you have successfully enrolled for "+tname+" Training.</b>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
		
	}
	

}

package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import service.Validate;

/**
 * Servlet implementation class ValidateServlet
 */
public class ValidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		String userName=req.getParameter("username");
		String password =req.getParameter("password");
		Validate validate=new Validate();
		String result=validate.validateLogin(userName, password);
		System.out.print(result); 
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("ResponseServlet").forward(req, resp);
	}

	
	

}

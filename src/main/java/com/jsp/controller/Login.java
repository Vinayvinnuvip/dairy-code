package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.User;
import com.jsp.service.UserService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		UserService us = new UserService();
		PrintWriter out = response.getWriter();
		User u=null;
		try {
			 u = us.getByEmail(email);
			if (u!=null) {
				String pass1=u.getPass();
				if(pass1.equals(pass)) {
					System.out.println("Login sucess");
					HttpSession session = request.getSession();
					session.setAttribute("email", u);
					request.getRequestDispatcher("home.jsp").forward(request, response);
					}else {
						request.getRequestDispatcher("index.jsp").include(request, response);
						out.print("<center>");
						out.print("check your passowrd");
						out.print("</center>");
					}

			} else{
				
				request.getRequestDispatcher("index.jsp").include(request, response);
				out.print("<center>");
				out.print("<p style='color:red'>check your details or register new..!</p>");
				out.print("</center>");
		}
		} catch (NullPointerException e) {
		
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.print("<center>");
			out.print("error user not exists");
			out.print("</center>");
		}
	}

}

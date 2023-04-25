package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.User;
import com.jsp.service.UserService;
@WebServlet("/get")
public class GetImage extends HttpServlet{
	UserService us=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	System.out.println(email);
	User u= us.getByEmail(email);
	ServletOutputStream s=resp.getOutputStream();
	byte[] b=u.getImage();
	s.write(b);
	}

}

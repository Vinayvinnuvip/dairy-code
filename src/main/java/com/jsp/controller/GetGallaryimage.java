package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Gallary;

import com.jsp.service.GallaryService;
@WebServlet("/getgallaryimage")
public class GetGallaryimage extends HttpServlet{
	GallaryService us=new GallaryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	System.out.println(email);
	Gallary u= us.getByEmail(email);
	ServletOutputStream s=resp.getOutputStream();
	byte[] b=u.getImage();
	s.write(b);
	}

}

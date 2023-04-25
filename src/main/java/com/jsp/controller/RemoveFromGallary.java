package com.jsp.controller;
import com.jsp.dto.Gallary;
import com.jsp.service.GallaryService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFromGallary
 * 
 */
@WebServlet("/removefromgallary")
public class RemoveFromGallary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String id=request.getParameter("id");
	GallaryService gs=new GallaryService();
	Gallary g=gs.getByEmail(id);
	gs.removeGallary(g);
	response.sendRedirect("getallgallary");
	}

}

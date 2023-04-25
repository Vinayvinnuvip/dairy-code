package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Gallary;
import com.jsp.dto.User;
import com.jsp.service.GallaryService;

@WebServlet("/getallgallary")
public class GetallGallary extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	User u=(User)session.getAttribute("email");
	String email=u.getEmail();
	GallaryService gs=new GallaryService();
	List<Gallary> list =gs.getAllGallary(email);
	req.setAttribute("image",list);
	req.getRequestDispatcher("gallary.jsp").include(req, resp);

	}
}

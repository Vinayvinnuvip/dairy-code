package com.jsp.controller;
import java.util.Date;  
import com.jsp.service.GallaryService;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.dto.Gallary;
@WebServlet("/saveimagegallary")
@MultipartConfig
public class SaveImageGallary extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Part p=req.getPart("image");
	String mail=req.getParameter("email");
	System.out.println(mail);
	String s=req.getParameter("disc");
	InputStream in=p.getInputStream();
	byte[] b=new byte[in.available()];
	in.read(b);
	Gallary g=new Gallary();
	g.setImage(b);
	g.setDisc(s);
    long millis = System.currentTimeMillis();  
    Date d=new Date(millis);
    String date=""+d;
	g.setDate_time(date);
	g.setEmail(mail);
	GallaryService  us=new GallaryService();
	us.saveGallary(g);
	resp.sendRedirect("getallgallary");
	}
}

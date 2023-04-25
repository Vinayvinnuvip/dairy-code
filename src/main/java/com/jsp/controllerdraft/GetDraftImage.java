package com.jsp.controllerdraft;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Draft;

import com.jsp.service.DraftService;
@WebServlet("/getdraftimage")
public class GetDraftImage extends HttpServlet{
	DraftService us=new DraftService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String date=req.getParameter("date");
	Draft u= us.getByEmail(date);
	System.out.println(date);
	ServletOutputStream s=resp.getOutputStream();
	byte[] b=u.getImage();
	s.write(b);
	
	}

}


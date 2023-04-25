package com.jsp.controllerfav;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Favorite;

import com.jsp.service.FavoriteService;
@WebServlet("/getfavimage")
public class GetFavimage extends HttpServlet{
	FavoriteService us=new FavoriteService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String date=req.getParameter("date");
	System.out.println(date);
	Favorite u= us.getByEmail(date);
	ServletOutputStream s=resp.getOutputStream();
	byte[] b=u.getImage();
	s.write(b);
	}

}


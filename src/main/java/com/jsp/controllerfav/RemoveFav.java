package com.jsp.controllerfav;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.FavoriteService;

@WebServlet("/removefav")
public class RemoveFav extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String date=req.getParameter("id");
		FavoriteService fs= new FavoriteService();
		fs.removeFavorite(date);
		resp.sendRedirect("getallfav");
	}

}

package com.jsp.controllerfav;

import java.io.IOException;

import com.jsp.dto.Gallary;
import com.jsp.dto.Favorite;
import com.jsp.service.GallaryService;
import com.jsp.service.FavoriteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtofav")
public class AddToFav extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String date=req.getParameter("id");
	GallaryService gs=new GallaryService();
	Gallary g=gs.getByEmail(date);
	Favorite f=new Favorite();
	f.setImage(g.getImage());
	f.setEmail(g.getEmail());
	f.setDisc(g.getDisc());
	f.setDate_time(g.getDate_time());
	FavoriteService fs=new FavoriteService();
	if(fs.getByEmail(g.getDate_time())==null) {
	fs.saveFavorite(f);
	}else {
		fs.removeFavorite(f.getDate_time());
	}
	resp.sendRedirect("getallgallary");
	}

}

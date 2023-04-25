package com.jsp.controllerfav;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Favorite;
import com.jsp.dto.User;
import com.jsp.service.FavoriteService;

@WebServlet("/getallfav")
public class GetallFav extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	User u=(User)session.getAttribute("email");
	String email=u.getEmail();
	FavoriteService fs=new FavoriteService();
	List<Favorite> list =fs.getAllFavorite(email);
	req.setAttribute("favlist",list);
	req.getRequestDispatcher("fav.jsp").include(req, resp);

	}
}

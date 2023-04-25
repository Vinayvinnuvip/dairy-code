package com.jsp.controllerdraft;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Draft;
import com.jsp.dto.User;
import com.jsp.service.DraftService;

@WebServlet("/getalldraft")
public class GetAllDraft extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	User u=(User)session.getAttribute("email");
	String email=u.getEmail();
	DraftService fs=new DraftService();
	List<Draft> list =fs.getAllDraft(email);
	req.setAttribute("draftlist",list);
	req.getRequestDispatcher("draft1.jsp").include(req, resp);

	}
}

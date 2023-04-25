package com.jsp.controllerdraft;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.DraftService;

@WebServlet("/removedraft")
public class RemoveDraft extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String date=req.getParameter("id");
		DraftService fs= new DraftService();
		fs.removeDraft(date);
		resp.sendRedirect("getalldraft");
	}

}

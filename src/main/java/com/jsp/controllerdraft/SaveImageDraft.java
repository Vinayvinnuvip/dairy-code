package com.jsp.controllerdraft;

import java.util.Date;  
import com.jsp.service.DraftService;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.dto.Draft;
@WebServlet("/saveimagedraft")
@MultipartConfig
public class SaveImageDraft extends HttpServlet {
	
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
	Draft g=new Draft();
	g.setImage(b);
	g.setDisc(s);
    long millis = System.currentTimeMillis();  
    Date d=new Date(millis);
    String date=""+d;
	g.setDate_time(date);
	g.setEmail(mail);
	DraftService  us=new DraftService();
	us.saveDraft(g);
	resp.sendRedirect("getalldraft");
	}
}

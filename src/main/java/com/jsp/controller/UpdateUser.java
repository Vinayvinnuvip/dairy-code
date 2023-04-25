package com.jsp.controller;
import com.jsp.dto.User;
import com.jsp.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet("/updateuser")
@MultipartConfig
public class UpdateUser extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String mobile=req.getParameter("mobile");
		String pass=req.getParameter("pass");
		Part p=req.getPart("image");
		InputStream in =p.getInputStream();
		byte[] image=new byte[in.available()];
		in.read(image);
		HttpSession session = req.getSession(false);
		User u=(User)session.getAttribute("email");
		User user=new User();
		user.setEmail(u.getEmail());
		user.setFname(fname);
		user.setLname(lname);
		user.setDob(dob);
		user.setGender(gender);
		user.setMobile(mobile);
		user.setPass(pass);
		user.setImage(image);
		user.setList(u.getList());
		user.setFavlist(u.getFavlist());
		user.setDraftlist(u.getDraftlist());
		UserService us=new UserService();
		User u1=us.updateUser(user);
		if(u1!=null) {	
			User u2=us.getByEmail(user.getEmail());
			session.setAttribute("email",u2);
			resp.sendRedirect("profile.jsp");
		}else{
			PrintWriter pw=resp.getWriter();
			resp.setContentType("html/text");
			pw.println("not updated");
			req.getRequestDispatcher("profile.jsp").include(req,resp);
		}
	}
}

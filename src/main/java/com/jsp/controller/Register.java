package com.jsp.controller;
import java.util.*;



import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.dto.Gallary;
import com.jsp.dto.Favorite;
import com.jsp.dto.User;
import com.jsp.service.UserService;
import com.jsp.service.GallaryService;
import com.jsp.service.FavoriteService;
@WebServlet("/register")
@MultipartConfig
public class Register extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		UserService us=new UserService();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String dob=request.getParameter("dob");
			String gender=request.getParameter("gender");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			String pass=request.getParameter("pass");
			Part p=request.getPart("image");
			InputStream in =p.getInputStream();
			byte[] image=new byte[in.available()];
			in.read(image);
			System.out.println(fname);
			PrintWriter out=response.getWriter();
			User u= new User();
			
			
			Gallary g=new Gallary();
			g.setEmail(email);
			g.setImage(image);
			g.setDate_time(dob);
			g.setDisc("profile pic");
			GallaryService gd=new GallaryService();
			gd.saveGallary(g);			
			
			u.setFname(fname);
			u.setLname(lname);
			u.setDob(dob);
			u.setGender(gender);
			u.setEmail(email);
			u.setMobile(mobile);
			u.setPass(pass);
			u.setImage(image);
			List<Gallary> list=new ArrayList<Gallary>();
			list.add(g);
			u.setList(list);
			
			User u1=us.saveUser(u);
			if(u1!=null) {
				out.print("saved");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
			out.print(" user already exits plz user another email");
			request.getRequestDispatcher("register.html").include(request, response);		
			}			
		}

	}

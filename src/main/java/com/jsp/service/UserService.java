package com.jsp.service;
import java.util.List;
import com.jsp.dao.UserDao;
import com.jsp.dto.Gallary;
import com.jsp.dto.User;

public class UserService {
UserDao us=new UserDao();
	public User saveUser(User u) {
	return us.saveUser(u);
	}
	
	
	public User updateUser(User u) {
		return us.updateUser(u);
	}
	public User removeUser(User u){
		return us.remove(u);
	}
	public List<User> getAllUser(){
		return us.getAllUser();
	}
	public User getByEmail(String email) {
		return us.getByEmail(email);
	}
}

package com.jsp.dto;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	private String email;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private String mobile;
	private String pass;
	@Lob
	private byte[] image; 
	@OneToMany(targetEntity=Gallary.class)  
	private List<Gallary>  list;
	@OneToMany(targetEntity=Favorite.class)
	private List<Favorite> favlist;
	@OneToMany(targetEntity=Draft.class)
	private List<Favorite> draftlist;

	public List<Favorite> getDraftlist() {
		return draftlist;
	}

	public void setDraftlist(List<Favorite> draftlist) {
		this.draftlist = draftlist;
	}

	public List<Favorite> getFavlist() {
		return favlist;
	}

	public void setFavlist(List<Favorite> favlist) {
		this.favlist = favlist;
	}

	public List<Gallary> getList() {
		return list;
	}

	public void setList(List<Gallary>  list) {
		this.list = list;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



}

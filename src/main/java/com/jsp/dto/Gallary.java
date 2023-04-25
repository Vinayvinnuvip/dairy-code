package com.jsp.dto;

import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Gallary {
	@Lob
	private byte[] image;
	@Id
	private String date_time;
	private String email;
	private String disc;
		
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
}

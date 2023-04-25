package com.jsp.service;

import java.util.List;
import com.jsp.dao.GallaryDao;
import com.jsp.dto.Gallary;

public class GallaryService {
	GallaryDao us = new GallaryDao();

	public Gallary saveGallary(Gallary u) {
		return us.saveGallary(u);
	}

	public Gallary updateGallary(Gallary u) {
		return us.updateGallary(u);
	}

	public Gallary removeGallary(Gallary u) {
		return us.removeGallary(u);
	}

	public List<Gallary> getAllGallary(String email) {
		return us.getAllGallary(email);
	}

	public Gallary getByEmail(String email) {
		return us.getByEmail(email);
	}
}

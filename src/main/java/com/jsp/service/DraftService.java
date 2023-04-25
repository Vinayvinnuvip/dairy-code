package com.jsp.service;

import java.util.List;
import com.jsp.dao.DraftDao;
import com.jsp.dto.Draft;

public class DraftService {
	DraftDao us = new DraftDao();

	public Draft saveDraft(Draft u) {
		return us.saveDraft(u);
	}

	public Draft updateDraft(Draft u) {
		return us.updateDraft(u);
	}

	public Draft removeDraft(String date) {
		return us.removeDraft(date);
	}

	public List<Draft> getAllDraft(String email) {
		return us.getAllDraft(email);
	}

	public Draft getByEmail(String date) {
		return us.getByEmail(date);
	}
}

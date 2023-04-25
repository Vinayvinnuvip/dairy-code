package com.jsp.service;

import java.util.List;
import com.jsp.dto.Favorite;
import com.jsp.dao.FavoriteDao;

public class FavoriteService {
	FavoriteDao us = new FavoriteDao();

	public Favorite saveFavorite(Favorite u) {
		return us.saveFavorite(u);
	}

	public Favorite updateFavorite(Favorite u) {
		return us.updateFavorite(u);
	}

	public Favorite removeFavorite(String date) {
		return us.removeFavorite(date);
	}

	public List<Favorite> getAllFavorite(String email) {
		return us.getAllFavorite(email);
	}

	public Favorite getByEmail(String email) {
		return us.getByEmail(email);
	}
}

package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Favorite;


public class FavoriteDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
	public Favorite saveFavorite(Favorite f) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(f);
		et.commit();
		return f;
		
	}

	public Favorite updateFavorite(Favorite u) {
		EntityManager em = emf.createEntityManager();
		Favorite u1 = em.find(Favorite.class, u.getEmail());
		if (u1 != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(u);
			et.commit();
		}
		return u;
	}

	public Favorite removeFavorite(String date) {
		EntityManager em = emf.createEntityManager();
		Favorite e = em.find(Favorite.class, date);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(e);
		et.commit();
		return e;
	}

	public List<Favorite> getAllFavorite(String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("select u from Favorite u where email=?1");
		q.setParameter(1,email);
		et.commit();
		return q.getResultList();
	}

	public Favorite getByEmail(String date) {
		EntityManager em = emf.createEntityManager();
		return em.find(Favorite.class, date);
	}
}

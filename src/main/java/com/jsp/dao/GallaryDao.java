package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Gallary;
import com.jsp.dto.User;

public class GallaryDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
	public Gallary saveGallary(Gallary g) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(g);
		et.commit();
		return g;
	}

	public Gallary updateGallary(Gallary u) {
		EntityManager em = emf.createEntityManager();
		User u1 = em.find(User.class, u.getEmail());
		if (u1 != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(u);
			et.commit();
		}
		return u;
	}

	public Gallary removeGallary(Gallary u) {
		EntityManager em = emf.createEntityManager();
		Gallary e = em.find(Gallary.class, u.getDate_time());
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(e);
		et.commit();
		return e;
	}
	

	public List<Gallary> getAllGallary(String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("select u from Gallary u where email=?1");
		q.setParameter(1,email);
		et.commit();
		return q.getResultList();
	}

	public Gallary getByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		Gallary g=em.find(Gallary.class,email);
		return g;
	}
}

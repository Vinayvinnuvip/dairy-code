package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Gallary;
import com.jsp.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
	public User saveUser(User u) {	
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		return u;
	}

	public User updateUser(User u) {
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

	public User remove(User u) {
		EntityManager em = emf.createEntityManager();
		User e = em.find(User.class, u.getEmail());
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(e);
		et.commit();
		return e;
	}

	public List<User> getAllUser() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("select u from user u");
		et.commit();
		return q.getResultList();
	}

	public User getByEmail(String email) {
		EntityManager em = emf.createEntityManager();
			return em.find(User.class, email);
	}
}

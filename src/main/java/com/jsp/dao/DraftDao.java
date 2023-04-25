package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.dto.Draft;


public class DraftDao {

	public Draft saveDraft(Draft g) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(g);
		et.commit();
		return g;
	}

	public Draft updateDraft(Draft u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
		EntityManager em = emf.createEntityManager();
		Draft u1 = em.find(Draft.class, u.getEmail());
		if (u1 != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(u);
			et.commit();
		}
		return u;
	}

	public Draft removeDraft(String date) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
		EntityManager em = emf.createEntityManager();
		Draft e = em.find(Draft.class, date);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(e);
		et.commit();
		return e;
	}

	public List<Draft> getAllDraft(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("select u from Draft u where email=?1");
		q.setParameter(1,email);
		et.commit();
		return q.getResultList();
	}

	public Draft getByEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vin");
		EntityManager em = emf.createEntityManager();
		return em.find(Draft.class, email);
	}
}

package com.hind.elibrary.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hind.elibrary.model.Book;

public class BookDaoImpl implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Collection<Book> getAll() {
		Query query = entityManager.createQuery("SELECT b FROM Book b");
		Collection<Book> result = query.getResultList();
		return result;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

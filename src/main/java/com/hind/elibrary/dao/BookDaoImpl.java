package com.hind.elibrary.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hind.elibrary.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	private Logger log = LoggerFactory.getLogger(BookDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Collection<Book> getAll() {
		log.info("!!!!!!!!!!!!! GetAll()");
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

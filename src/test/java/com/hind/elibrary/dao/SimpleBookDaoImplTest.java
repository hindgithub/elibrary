package com.hind.elibrary.dao;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.hind.elibrary.model.Book;

public class SimpleBookDaoImplTest {

	@Test
	public void getAllBooksShouldReturnAlwaysThisSameContent() {
		//given
		SimpleBookDaoImpl dao = new SimpleBookDaoImpl();

		//when
		Collection<Book> books = dao.getAll();
		int size = books.size();
		books.add(new Book());

		//then
		Assert.assertEquals(size, dao.getAll().size());
	}

}

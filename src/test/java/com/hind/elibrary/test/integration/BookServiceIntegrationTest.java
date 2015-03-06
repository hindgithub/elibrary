package com.hind.elibrary.test.integration;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.spring.SpringContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class BookServiceIntegrationTest {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookService bookService;

	@Test
	@Ignore
	public void shouldReturnAllBooks() {
		//given

		//when
		Collection<Book> booksResult = bookService.getAllBooks();

		//then
		Assert.assertEquals(bookDao.getAll().size(), booksResult.size());
	}

}

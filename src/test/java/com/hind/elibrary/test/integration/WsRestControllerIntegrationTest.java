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
import com.hind.elibrary.spring.SpringContextConfiguration;
import com.hind.elibrary.webservice.rest.WsRestController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class)
public class WsRestControllerIntegrationTest {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private WsRestController wsRestController;

	@Test
	@Ignore
	public void shouldReturnAllBooks() {
		//given

		//when
		Collection<Book> booksResult = wsRestController.getAllBooks();

		//then
		Assert.assertEquals(bookDao.getAll().size(), booksResult.size());
	}

}

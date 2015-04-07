package com.hind.elibrary.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.test.dao.SpringContextConfiguration4TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextConfiguration4TestDao.class })
public class BookDaoImplTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BookDao bookDao;

	@Test
	public void shouldGetAllMethodReturnAllBooks() {
		//given

		//when
		Collection<Book> results = bookDao.getAll();

		//then
		Assert.assertThat(results, Matchers.allOf(Matchers.notNullValue(), Matchers.hasSize(1)));
		Assert.assertThat(results, Matchers.contains(Matchers.allOf(
				Matchers.hasProperty("author", Matchers.equalTo("Maria Konopnicka")),
				Matchers.hasProperty("title", Matchers.equalTo("Nasza szkapa")),
				Matchers.hasProperty("id", Matchers.equalTo(1l)))
				));
	}

	@Test
	public void shouldGetMethodReturnBooksWhenGiveExistingId() {
		//given

		//when
		Book resultBook = bookDao.get(1l);

		//then
		Assert.assertThat(resultBook, Matchers.allOf(
				Matchers.hasProperty("author", Matchers.equalTo("Maria Konopnicka")),
				Matchers.hasProperty("title", Matchers.equalTo("Nasza szkapa")),
				Matchers.hasProperty("id", Matchers.equalTo(1l))
				));
	}

	@Test
	public void shouldGetMethodNotReturnBooksWhenGivenNotExistingId() {
		//given
		Long notExistId = -1l;

		//when
		Book resultBook = bookDao.get(notExistId);

		//then
		Assert.assertNull(resultBook);
	}
}

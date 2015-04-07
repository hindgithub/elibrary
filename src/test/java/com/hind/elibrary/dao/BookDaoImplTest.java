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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextConfiguration4TestDao.class })
public class BookDaoImplTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BookDao bookDao;

	@Test
	public void test() {
		//given

		//when
		Collection<Book> result = bookDao.getAll();

		//then
		Assert.assertThat(result, Matchers.allOf(Matchers.notNullValue(), Matchers.hasSize(0)));
	}

}

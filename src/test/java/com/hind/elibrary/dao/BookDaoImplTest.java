package com.hind.elibrary.dao;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/hind/elibrary/test/dao/spring-context-configuration-test-dao.xml")
public class BookDaoImplTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void test() {
		Assert.assertNotNull(dataSource);
	}

}

package com.hind.elibrary.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.dao.SimpleBookDaoImpl;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.service.BookServiceImpl;

@Configuration
public class SpringContextConfiguration {

	@Bean
	public BookDao getBookDao() {
		return new SimpleBookDaoImpl();
	}

	@Bean
	public BookService getBookService() {
		BookServiceImpl bookService = new BookServiceImpl();
		bookService.setBookDao(getBookDao());
		return bookService;
	}
}

package com.hind.elibrary.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.dao.SimpleBookDaoImpl;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.service.BookServiceImpl;
import com.hind.elibrary.webservice.rest.WsRestController;

@Configuration
@EnableWebMvc
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

	@Bean
	public WsRestController getRestControler() {
		return new WsRestController();
	}
}

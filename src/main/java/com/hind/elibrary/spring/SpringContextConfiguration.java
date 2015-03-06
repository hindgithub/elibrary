package com.hind.elibrary.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.dao.SimpleBookDaoImpl;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.service.BookServiceImpl;
import com.hind.elibrary.webservice.rest.WsRestController;
import com.hind.elibrary.webservice.soap.WsSoapController;

@Configuration
@EnableWebMvc
@ImportResource("classpath:/com/hind/elibrary/spring/spring-context-configuration.xml")
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
	public WsRestController getWsRestController() {
		WsRestController wsRestController = new WsRestController();
		wsRestController.setBookService(getBookService());
		return wsRestController;
	}

	@Bean
	public WsSoapController getWsSoapController() {
		WsSoapController wsSoapController = new WsSoapController();
		wsSoapController.setBookService(getBookService());
		return wsSoapController;
	}
}

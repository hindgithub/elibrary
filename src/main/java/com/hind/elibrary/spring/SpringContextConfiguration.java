package com.hind.elibrary.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.server.SoapMessageDispatcher;
import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;

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

	@Bean(name = { "bookService" })
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

	/*configuration for serving soap webservices by DispatcherServlet*/
	@Bean
	public SaajSoapMessageFactory getSoapMessageFactory() {
		return new SaajSoapMessageFactory();
	}

	@Bean
	public WebServiceMessageReceiverHandlerAdapter getWebServiceMessageReceiverHandlerAdapter() {
		WebServiceMessageReceiverHandlerAdapter bean = new WebServiceMessageReceiverHandlerAdapter();
		bean.setMessageFactory(getSoapMessageFactory());
		return bean;
	}

	@Bean
	public WsdlDefinitionHandlerAdapter getWsdlDefinitionHandlerAdapter() {
		return new WsdlDefinitionHandlerAdapter();
	}

	@Bean
	public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
		return new RequestMappingHandlerAdapter();
	}

	@Bean
	public SoapMessageDispatcher getSoapMessageDispatcher() {
		return new SoapMessageDispatcher();
	}

	@Bean
	public SimpleUrlHandlerMapping getSimpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping bean = new SimpleUrlHandlerMapping();
		bean.setDefaultHandler(getSoapMessageDispatcher());
		return bean;
	}
	/*end configuration for serving soap webservices by DispatcherServlet*/
}

package com.hind.elibrary.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.server.SoapMessageDispatcher;
import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.dao.BookDaoImpl;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.service.BookServiceImpl;
import com.hind.elibrary.webservice.rest.WsRestController;
import com.hind.elibrary.webservice.soap.WsSoapController;

@Configuration
@EnableWebMvc
@ImportResource("classpath:/com/hind/elibrary/spring/spring-context-configuration.xml")
public class SpringContextConfiguration {

	@Autowired
	private DataSource dataSource;

	@Bean
	public BookDao getBookDao() {
		BookDaoImpl bookDao = new BookDaoImpl();
		return bookDao;
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

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "com.hind.elibrary.model" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(getJpaProperties());
		return em;
	}

	private Properties getJpaProperties() {
		Properties properties = new Properties();
		//		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		return properties;
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

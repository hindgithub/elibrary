package com.hind.elibrary.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

import com.hind.elibrary.dao.ComponentScanMarker4Daos;
import com.hind.elibrary.service.ComponentScanMarker4Services;
import com.hind.elibrary.webservice.rest.WsRestController;
import com.hind.elibrary.webservice.soap.WsSoapController;

@Configuration
@EnableWebMvc
@ImportResource("classpath:/com/hind/elibrary/spring/spring-context-configuration.xml")
@ComponentScan(basePackageClasses = { ComponentScanMarker4Daos.class,
		ComponentScanMarker4Services.class, WsRestController.class,
		WsSoapController.class})
public class SpringContextConfiguration {

	/* configuration for JPA */
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
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
		// properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.HSQLDialect");
		return properties;
	}

	/* configuration for serving soap webservices by DispatcherServlet */
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
	/* end configuration for serving soap webservices by DispatcherServlet */
}

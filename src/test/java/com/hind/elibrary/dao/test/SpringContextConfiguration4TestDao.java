package com.hind.elibrary.dao.test;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.hind.elibrary.dao.ComponentScanMarker4Daos;

@Configuration
@ImportResource("classpath:/com/hind/elibrary/dao/test/spring-context-configuration-4-test-dao.xml")
@ComponentScan(basePackageClasses = { ComponentScanMarker4Daos.class })
public class SpringContextConfiguration4TestDao {

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
}

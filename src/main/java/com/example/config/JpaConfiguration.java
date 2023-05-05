package com.example.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages= {"com.example.repository"})
@EnableTransactionManagement
public class JpaConfiguration {
	
	
	//Khởi tạo đối tượng manager factory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		//load data source của mysql
		em.setDataSource(dataSource());
		
		//load  persistence-data trong file persinstence.xml
		em.setPersistenceUnitName("persistence-data");
		
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em ;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springmvcbasic");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		return datasource;
	}

	
	public Properties additionalProperties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto","create-drop");
//		properties.setProperty("hibernate.hbm2ddl.auto","create");
//		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.setProperty("hibernate.hbm2ddl.auto","none");
		properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
		return properties;
	}
	
}

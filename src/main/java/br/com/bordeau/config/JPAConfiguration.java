package br.com.bordeau.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties additionalProperties) {
		LocalContainerEntityManagerFactoryBean factoryBean
			= new LocalContainerEntityManagerFactoryBean();
		
		// Local onde estão os models para serem criados as tabelas
		factoryBean.setPackagesToScan("br.com.bordeau.model");
		
		// Seta a framework que cuidará das transações do banco de dado
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaProperties(additionalProperties);
		return factoryBean;
	}
	
	// MYSQL CONFIG
	@Bean
	public Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}
	
	@Bean
	public DriverManagerDataSource dataSurce() {
		// em caso de dúvidas
		// https://askubuntu.com/questions/763336/cannot-enter-phpmyadmin-as-root-mysql-5-7
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("phpmyadmin");
		dataSource.setPassword("some_pass");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bordeau?autoReconnect=true&useSSL=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}

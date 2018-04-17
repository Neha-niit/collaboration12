package com.niit.confiq;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.BlogDAOImpl;
import com.niit.DAO.ForumDAO;
import com.niit.DAO.ForumDAOImpl;
import com.niit.DAO.JobDAO;
import com.niit.DAO.JobDAOImpl;
import com.niit.DAO.UserDAO;
import com.niit.DAO.UserDAOImpl;
import com.niit.model.ApplyJob;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Friends;
import com.niit.model.Job;
import com.niit.model.UserDetails;

@Configuration
@ComponentScan("com,niit")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean
	public DataSource getDataSource()
	{   
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:11.2:XE");
		dataSource.setUsername("Neha");
		dataSource.setPassword("Neha");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getsessionFactory() 
	{
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle11gDialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder 
			    sessionFactoryBuilder.addProperties(hibernateProp);
		
		
		sessionfactoryBuilder.addAnnotatedClass(Blog.class);
		sessionfactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionfactoryBuilder.addAnnotatedClass(UserDetail.class);
		sessionfactoryBuilder.addAnnotatedClass(job.class);
		
		
		
		SessionFactoryBuilder sessionFactoryBuilder.buildSessionFactory();
		System.out.println("----- SessionFactory Object------");
		return sessionFactory;

	}
	@Bean(name="jobDAO")
	public JobDAO getjobDAO()
	{
		return new JobDAOImpl();
	}
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO()
	{
		return new ForumDAOImpl();
	}
	@Bean(name="userDetailDAO")
	public UserDAO getCategoryDAO()
	{
		return new UserDetailDAOImpl();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

}


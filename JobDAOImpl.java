package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.model.Job;

@Repository("jobDAOImpl")
public  class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;
    
	@Override
	@Transactional
	public boolean addJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}
	
	@Override
	@Transactional
	public Job getJob(int jobId)
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,jobId);
		session.close();
		return job;
		
	}

	@Override
	@Transactional
	public boolean deleteJob(Job job) {
		try
		{
		   
		   sessionFactory.getCurrentSession().delete(job);
		   return true;
		}
		catch(Exception e)
		{
			return false;
			
		}	
		
	}

	@Override
	@Transactional
	public boolean updateJob(Job Job) {
		try
		{
			sessionFactory.getCurrentSession().update(Job);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	@Override
	public List<Job> listJobs() 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			List<Job> listJobs=query.list();
			return listJobs;
		}
		catch(Exception e)
		{
			return null;
        }

	}

	@Override
	public com.niit.dao.Job getJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}


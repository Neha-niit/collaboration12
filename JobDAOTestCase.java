package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.dao.JobDAO;
import com.niit.dao.Job;

public class JobDAOTestCase 
{
	static JobDAO jobDAO;
		
	    @BeforeClass
	    public static void initialize()
	    {
	    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	    	context.scan("com.niit");
	    	context.refresh();
	      	jobDAO=(JobDAO)context.getBean("jobDAO");
	    	
	    }
	    
	    @Test
	    public void addTestCase()
	    {
	    	Job job=new Job();
	    	
	    	
	    	job.setJobDesignation("Programmer");
	    	job.setJobDesc("Need to the coding with different technology");
	    	job.setCompany("RedSkyInc");
	    	job.setLocation("Delhi");
	    	job.setSalary(45000);
	    	job.setLatDateApply(new java.util,Date());
	     	assertTrue("Problem in Adding Job ", jobDAO.addJob(job));
	    	
	    }
	    @Ignore
	    @Test
	    public void deleteJobTest()
	    {
			Job job=jobDAO.getJob(952);
			job.setJobDesc("Programmer");
			assertTrue("Problem in Updation",jobDAO.deleteJob(job));

	    }
	    
	    
	    @Test
	    public void udateJobTest()
	    {
			Job job=jobDAO.getJob(952);
			job.setJobDesc("Programmer");
			assertTrue("Problem in Updation",jobDAO.updateJob(job));

	    }
	    
	    @Test
		public void listJobsTest()
		{
			List<Job> listJobs=jobDAO.listJobs();
			assertNotNull("No Jobs",listJobs);
			
			for(Job job:listJobs)
			{
				System.out.print(job.getCompany()+":::");
				System.out.print(job.getJobDesc()+":::");
			}
		}


	}
 
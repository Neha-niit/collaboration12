package com.niit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;


@Repository("userDetailDAO")

public class UserDetailDAOImpl implements UserDetailDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean registeruser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetails);
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception araised:"+e);
		    return false;
		}
		
		
	}

	@Override
 	@Transactional
	public boolean checkCredential(UserDetail userDetail) {
		try
		{
		    Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetials where loginname=:loginname and password");
			query.setParameter("loginname",userDetail.getloginname());
			query.setParameter("password",userDetail.getpassword());
			UserDetail userDetail1=(UserDetail)query.list().get(0);
			if(userDetail1==null)
		}
		   return false;  
		{
	    else
	    {
	    	return true;
	    } 	
		catch(Exception e)
		{
			return false;
			
		}
		
	}

	

	
	
	@Override
	@Transactional
	public UserDetails getUser(String loginname) 
	{
		Session session=sessionFactory.openSession();
		UserDetails userDetail=(UserDetails)session.get(UserDetails.class,loginname);
		session.close();
		return userDetail;
	}

}

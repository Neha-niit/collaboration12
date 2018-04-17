package com.niit.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.dao.UserDetailDAO;
import com.niit.dao.UserDetails;

import org.junit.Test;

public class UserDetailDAOTestCase {
	static UserDetailDAO userDetailDAO;
	
    @BeforeClass
    public static void initialize()
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	userDetailDAO=(UserDEtailDAO)context.getBean("userDetailDAO");
    	
    }
    
    @Test
    public void registeruserTest()
    {
    	userDetail userDetail=new UserDetail();
    	userDetail.setLoginnameName("Neha");
    	userDetail.setPassword("Neha123");
    	userDetail.setUserName("Neha Ghosh");
    	userDetail.setEmailId("neha@gmail.com");
    	userDetail.setAddress("Kolkata");
    	userDetail.setMobileNo("9830373217");
    	userDetail.setRole("ROLE ADMIN");
    	
    	asserTrue("Problem in Registering User", userDetailDAO.registerUser (userDetail));
    	
    }
    
    
    @Test
    public void checkuserTest()
    {
    	userDetail userDetail=new UserDetail();
    	userDetail.setLoginnameName("Tuli");
    	userDetail.setPassword("Tuli123");
    	userDetail.setUserName("Tuli Ghosh");
    	userDetail.setEmailId("tuli@gmail.com");
    	userDetail.setAddress("Kolkata");
    	userDetail.setMobileNo("9831373217");
    	userDetail.setRole("ROLE USER");
    	
        asserTrue("Problem in Login Proccess", userDetailDAO.checkcredential(userDetail));
    	
    }
    
  /*  @Ignore
    @Test
    public void deleteBlogTest()
    {
    	assertTrue("Problem in blog deletion",blogDAO.deleteBlog(blog));
    }
    */
    
    @Ignore
    @Test
    public void rejectBlogTest()
    {
    	Blog blog=blogDAO.getBlog(0);
    	assertTrue("Problem in blog rejection",blogDAO.rejectBlog(blog));
    }
    @Ignore
    @Test
    public void approvalBlogTest()
    {
    	Blog blog=blogDAO.getBlog(0);
    	assertTrue("Problem in blog approval",blogDAO.approveBlog(blog));
    }
    
    @Test
    public void listBlogsByUserTest()
    {
    	List<Blog> listBlogs=blogDAO.listBlogs("Deepi");
    	assertTrue("Problem in listing the Blog",listBlogs.size()>0);
    	
    	for(Blog blog:listBlogs)
    	{
    		System.out.println(blog.getBlogName()+":::");
    		System.out.println(blog.getBlogContext()+":::");
    		System.out.println(blog.getLoginname()+":::");
    	}
    	
    }
    
    @Test
    public void incrementBlogLikeTest()
    {
    	Blog blog=blogDAO.getBlog(250);
    	assertTrue("Problem in incrementing likes",blogDAO.incrementLikes(blog));
    }
    
    @Test
    public void addCommentTest()
    {
    	BlogComment comment=new BlogComment();
    	comment.setCommentText("This blog is very informative");
    	comment.setLoginname("Vicky");
    	comment.setCommentDate(new java.util.Date());
    	assertTrue("Problem in insertion of Blog Comment ",blogDAO.addBlogComment(comment));
    }
    
    @Test
    public void listAllBlogCommentTest()
    {
    	List<BlogComment> listBlogComments= blogDAO.listBlogComments(0);
    	assertTrue("Problem in retrieving all the BlogComments",listBlogComments.size()>0);
    	
    	for(BlogComment blogComment:listBlogComments)
    	{
    		System.out.println(blogComment.getBlogId()+":::");
    		System.out.println(blogComment.getCommentText()+":::");
    		System.out.println(blogComment.getLoginname()+":::");
    	}
    }
    
}

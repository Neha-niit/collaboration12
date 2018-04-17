package com.niit.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BlogController
{
	@Autowired
	 BlogDAO BlogDAO;
	

    @GetMapping(value="/showALLApprovedBlogs")
	public ResponseEntity<List<Blog>> showALLApprovedBlog()
	{
    	List<Blog> listBlogs=BlogDAO. listApprovedBlogs("neha") ;
	   
	   if(listBlogs!=null)
	   {   
		return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
	   }
	   else
		   return new ResponseEntity<List<Blog>>("listBlogs",HttpStatus.INTERNEL_SERVER_ERROR);
	   
	}
    @PostMapping(value="/addBlog")
    public ResponseEntity<String> addBlog(@RequestBody Blog blog)
    {
    	blog.setCreatDate(new java.util.Date());
    	blog.setLikes(0);
    	blog.setLoginname("neha");
    	blog.setStatus("NA");
    	
    	System.out.println("Blog Name:"+blog.getBlogName());
    	System.out.println("Blog Content:"+blog.getBlogContent());
    	{
    		return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Failure",HttpStatus.INTERNEL_SERVER_ERROR);
    	}
    }
    @GetMapping(value="/approveBloge/{blogId}")
   	public ResponseEntity<String> approvedBlog(@PathVariable("blogId") int blogId)
   	{
       	Blog blog=(Blog)blogDAO.getBlog(blogId);
   	   
   	   if(listBlogs!=null)
   	   {   
   		return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
   	   }
   	   else
   		   return new ResponseEntity<List<Blog>>("listBlogs",HttpStatus.INTERNEL_SERVER_ERROR);
   	   
   	}
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

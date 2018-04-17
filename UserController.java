package com.niit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;


@RestController
public class UserController<userDetailDAO> 
{
	@Autowired
	  UserDetail userDetailDAO;


	  
	  @PostMapping(value="/registerUser")
		public <userDetailDAO> ResponseEntity<String> registerUser(@RequestBody UserDetail userDetail)
		{
		  
		   if(userDetailDAO.registerUser(userDetail))
		   {   
			return new ResponseEntity<String>("Successfully Registered",HttpStatus.OK);
		   }
		   else
			   return new ResponseEntity<String>("Problem in Registering",HttpStatus.UNAUTHORIZED);
		   
		   
		   }

          
		@PostMapping(value="/checkUser")
		public ResponseEntity<UserDetail> checkUser(@RequestBody UserDetail userDetail)
		{
			if(userDAO.checkCredential(userDetail))
			{
				UserDetail tempUser=userDAO.getUser(userDetail.getLoginname());
				return new ResponseEntity<UserDetail>(tempUser,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<UserDetail>(userDetail,HttpStatus.UNAUTHORIZED);
			}
		}
		

	}


 


}



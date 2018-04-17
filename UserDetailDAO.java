package com.niit.dao;


import com.niit.model.UserDetails;

public interface UserDetailDAO
{
	public boolean registerUser(UserDetails userdetail);
	public boolean checkCredential(UserDetails userDetail);
	public UserDetails getUser(String loginname);
}
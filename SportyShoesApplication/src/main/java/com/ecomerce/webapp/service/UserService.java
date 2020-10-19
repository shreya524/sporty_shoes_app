package com.ecomerce.webapp.service;

import java.util.List;

import com.ecomerce.webapp.entity.User;

public interface UserService {

	public User createUser(User user);
	public List<User> getAllUsers();
	public void deleteByUserId(int uId);
	public User findByUserId(int uId);
	public User updateUser(User user);
		
}

package com.kalyan.demo.service;

import java.util.List;

import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUser(int id);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public User deleteUser(int id);

}

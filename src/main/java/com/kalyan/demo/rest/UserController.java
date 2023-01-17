package com.kalyan.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.User;
import com.kalyan.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
		
	}
	
	
	@GetMapping("/user")
	public List<User> getUsers() {
		return this.userServiceImpl.getUsers();
		
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable int userId) {
		User user = this.userServiceImpl.getUser(userId);
		return user;
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		if (user.getId() != null) user.setId(null);
		return this.userServiceImpl.addUser(user);
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return this.userServiceImpl.updateUser(user);
	}

}

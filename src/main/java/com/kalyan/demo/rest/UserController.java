package com.kalyan.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.demo.entity.User;
import com.kalyan.demo.service.UserService;
import com.kalyan.demo.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	private UserService userServiceImpl;

	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;

	}

	@GetMapping(value = "/users")
	public Object getUsers() {
		return this.userServiceImpl.getUsers();
	}

	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable(value = "userId") int userId) {
		;
		return this.userServiceImpl.getUser(userId);
	}

	@PostMapping(value = "/user/create")
	public User addUser(@RequestBody User user) {
		if (user.getId() != null)
			user.setId(null);
		return this.userServiceImpl.addUser(user);
	}

	@PutMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		return this.userServiceImpl.updateUser(user);
	}

	@DeleteMapping(value = "/user/delete/{userId}")
	public User deleteUser(@PathVariable int userId) {
		User user = this.userServiceImpl.deleteUser(userId);
		return user;
	}

}

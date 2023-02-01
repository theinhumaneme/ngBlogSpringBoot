package com.kalyan.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kalyan.demo.entity.User;

@Service

public interface UserService {

	public List<User> getUsers();

	public User getUser(int id);

	public User addUser(User user);

	public User updateUser(User user);

	public User deleteUser(int id);

	public User upvotePost(int userId, int postId);

	public User upvoteComment(int userId, int commentId);

	public User downvotePost(int userId, int postId);

	public User downvoteComment(int userId, int commentId);
}

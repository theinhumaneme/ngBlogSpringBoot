package com.kalyan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VoteService voteService;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		if (this.userRepository.existsById(id) == true) {
			return this.userRepository.findById(id).get();
		} else {
			throw new RuntimeException("User with id, doesn't exist");
		}
	}

	@Override
	public User addUser(User user) {
		this.userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		if (this.userRepository.existsById(user.getId()) == true) {
			this.userRepository.save(user);
			return user;
		} else {
			throw new RuntimeException("User doesn't exist");
		}
	}

	@Override
	public User deleteUser(int id) {
		if (this.userRepository.existsById(id) == true) {
			User user = this.userRepository.findById(id).get();
			this.userRepository.deleteById(id);
			return user;
		} else {
			throw new RuntimeException("User doesn't exist");
		}
	}

	@Override
	public User upvotePost(int userId, int postId) {
		if (this.voteService.upvotePost(userId, postId) != false) {
			return this.userRepository.findById(userId).get();
		}
		return null;
	}

	@Override
	public User upvoteComment(int userId, int commentId) {
		if (this.voteService.upvoteComment(userId, commentId) != false) {
			return this.userRepository.findById(userId).get();
		}
		return null;
	}

	@Override
	public User downvotePost(int userId, int postId) {
		if (this.voteService.downvotePost(userId, postId) != false) {
			return this.userRepository.findById(userId).get();
		}
		return null;
	}

	@Override
	public User downvoteComment(int userId, int commentId) {
		if (this.voteService.downvotedComment(userId, commentId) != false) {
			return this.userRepository.findById(userId).get();
		}
		return null;
	}

}

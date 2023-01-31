package com.kalyan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.PostRepository;
import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.Post;
import com.kalyan.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

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
	public User upvotePost(int id, int postId) {
		if (this.userRepository.existsById(id) == true) {
			User user = this.userRepository.findById(id).get();
			if (user.getUpvotedPosts().contains(postRepository.findById(postId).get()) == true) {
				// return user;
				throw new RuntimeException("Post Already Upvoted by user");
			} else if (this.postRepository.existsById(postId)) {
				Post post = this.postRepository.findById(postId).get();
				user.getUpvotedPosts().add(post);
				user.setUpvotedPosts(user.getUpvotedPosts());
				this.userRepository.save(user);
				return user;
			}
		} else {
			throw new RuntimeException("User doesn't exist");
		}
		// this.postRepository.ge
		return null;
	}

}

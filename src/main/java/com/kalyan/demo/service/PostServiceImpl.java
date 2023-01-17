package com.kalyan.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.PostRepository;
import com.kalyan.demo.entity.Post;
import com.kalyan.demo.entity.User;


@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private UserService userService;
	public PostServiceImpl(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
		
	}
	
	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return this.postRepository.findAll();
	}

	@Override
	public Post getPost(int id) {
		if(this.postRepository.existsById(id) == true) {
			return this.postRepository.findById(id).get();
		}
		else {
			throw new RuntimeException("Post does not exist");
		}
	}

	@Override
	public Post addPost(Post post, int userId) {
		User user = this.userService.getUser(userId);
		post.setUser(user);
		post.setDateCreated(Date.valueOf(LocalDate.now()));
		this.postRepository.save(post);
		return post;
	}
	@Override
	public Post updatePost(Post post) {
		if (this.postRepository.existsById(post.getId())== true){
			Post orgPost = this.postRepository.findById(post.getId()).get();
			orgPost.setTitle(post.getTitle());
			orgPost.setContent(post.getContent());
			orgPost.setLastEdited(Date.valueOf(LocalDate.now()));
			this.postRepository.save(orgPost);
			return orgPost;
		}
		else {
			throw new RuntimeException("Post doesn't exist");
		}
	}
	@Override
	public Post deletePost(int id) {
		if(this.postRepository.existsById(id)==true) {
			Post post = this.postRepository.findById(id).get();
			this.postRepository.deleteById(id);
			return post;
		}
		else {
			throw new RuntimeException("Post doesn't exist");
		}
	}

}

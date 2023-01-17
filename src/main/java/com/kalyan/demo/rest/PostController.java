package com.kalyan.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.Post;
import com.kalyan.demo.entity.User;
import com.kalyan.demo.service.PostServiceImpl;

@RestController
@RequestMapping("/api")
public class PostController {
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public PostController(PostServiceImpl postServiceImpl) {
		this.postServiceImpl = postServiceImpl;
		
	}
	
	
	@GetMapping("/post")
	public List<Post> getPosts() {
		return this.postServiceImpl.getPosts();
		
	}
	
	@GetMapping("/post/{postId}")
	public Post getPostById(@PathVariable int postId) {
		Post post = this.postServiceImpl.getPost(postId);
		return post;
	}
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post, @RequestParam(name="userId") int userId) {
		if (post.getId() != null) post.setId(null);
		return postServiceImpl.addPost(post, userId);
		
	}
	@PutMapping("/post")
	public Post updatePost(@RequestBody Post post) {
		return this.postServiceImpl.updatePost(post);
	}
	@DeleteMapping("/post/{postId}")
	public Post deletePost(@PathVariable int postId) {
		Post post= this.postServiceImpl.deletePost(postId);
		return post;
	}

}

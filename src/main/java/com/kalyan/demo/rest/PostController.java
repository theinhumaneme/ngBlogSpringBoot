package com.kalyan.demo.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.demo.entity.Post;
import com.kalyan.demo.service.PostServiceImpl;

@RestController
@RequestMapping(value = "/api",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
	private PostServiceImpl postServiceImpl;

	public PostController(PostServiceImpl postServiceImpl) {
		this.postServiceImpl = postServiceImpl;

	}

	@GetMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Post> getPosts() {
		return this.postServiceImpl.getPosts();

	}

	@GetMapping(value = "/post/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Post getPostById(@PathVariable int postId) {
		Post post = this.postServiceImpl.getPost(postId);
		return post;
	}

	@PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Post addPost(@RequestBody Post post, @RequestParam(name = "userId") int userId) {
		if (post.getId() != null)
			post.setId(null);
		return postServiceImpl.addPost(post, userId);

	}

	@PutMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Post updatePost(@RequestBody Post post) {
		return this.postServiceImpl.updatePost(post);
	}

	@DeleteMapping(value = "/post/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Post deletePost(@PathVariable int postId) {
		Post post = this.postServiceImpl.deletePost(postId);
		return post;
	}

}

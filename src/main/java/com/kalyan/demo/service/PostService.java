package com.kalyan.demo.service;

import java.util.List;

import com.kalyan.demo.entity.Post;

public interface PostService {

	public List<Post> getPosts();

	public Post getPost(int id);

	public Post addPost(Post Post, int userId);

	public Post updatePost(Post Post);

	public Post deletePost(int id);

}

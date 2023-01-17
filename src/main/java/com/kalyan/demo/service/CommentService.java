package com.kalyan.demo.service;

import java.util.List;

import com.kalyan.demo.entity.Comment;

public interface CommentService {
	
	public List<Comment> getComments();
	
	public Comment getComment(int id);
	
	public Comment addComment(Comment Comment, int postId, int userId);
	
	public Comment updateComment(Comment Comment);
	
	public Comment deleteComment(int id);

}

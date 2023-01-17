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

import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.service.CommentServiceImpl;

@RestController
@RequestMapping("/api")
public class CommentController {
	private CommentServiceImpl commentServiceImpl;
	
	@Autowired
	public CommentController(CommentServiceImpl commentServiceImpl) {
		this.commentServiceImpl = commentServiceImpl;
		
	}
	
	
	@GetMapping("/comment")
	public List<Comment> getComments() {
		return this.commentServiceImpl.getComments();
		
	}
	
	@GetMapping("/comment/{commentId}")
	public Comment getCommentById(@PathVariable int commentId) {
		Comment comment = this.commentServiceImpl.getComment(commentId);
		return comment;
	}
	
//	@PostMapping("/comment")
//	public Comment addComment(@RequestBody Comment comment, @RequestParam(name="postId") int postId, @RequestParam(name="userId") int userId) {
//		if (comment.getId() != null) comment.setId(null);
//		return this.commentServiceImpl.addComment(comment, postId, userId);
//	}
	@PutMapping("/comment")
	public Comment updateComment(@RequestBody Comment comment) {
		return this.commentServiceImpl.updateComment(comment);
	}
	@DeleteMapping("/comment/{commentId}")
	public Comment deleteComment(@PathVariable int commentId) {
		Comment comment= this.commentServiceImpl.deleteComment(commentId);
		return comment;
	}

}

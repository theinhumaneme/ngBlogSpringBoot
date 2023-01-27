package com.kalyan.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.CommentRepository;
import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.entity.Post;
import com.kalyan.demo.entity.User;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;
	private PostService postService;
	private UserService userService;

	public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	@Override
	public List<Comment> getComments() {
		return this.commentRepository.findAll();
	}

	@Override
	public Comment getComment(int id) {
		if (this.commentRepository.existsById(id) == true) {
			return this.commentRepository.findById(id).get();
		} else {
			throw new RuntimeException("Comment does not exist");
		}
	}

	@Override
	public Comment addComment(Comment comment, int postId, int userId) {
		Post post = this.postService.getPost(postId);
		User user = this.userService.getUser(userId);
		comment.setUser(user);
		comment.setPost(post);
		comment.setdate_created(Date.valueOf(LocalDate.now()));
		this.commentRepository.save(comment);
		return comment;
	}

	@Override
	public Comment updateComment(Comment comment) {
		if (this.commentRepository.existsById(comment.getId()) == true) {
			Comment commentUpdated = this.commentRepository.findById(comment.getId()).get();
			commentUpdated.setContent(comment.getContent());
			commentUpdated.setdate_edited(Date.valueOf(LocalDate.now()));
			this.commentRepository.save(commentUpdated);
			return commentUpdated;
		} else {
			throw new RuntimeException("Comment doesn't exist");
		}
	}

	@Override
	public Comment deleteComment(int id) {
		if (this.commentRepository.existsById(id) == true) {
			Comment comment = this.commentRepository.findById(id).get();
			this.commentRepository.deleteById(id);
			return comment;
		} else {
			throw new RuntimeException("Comment doesn't exist");
		}
	}

}

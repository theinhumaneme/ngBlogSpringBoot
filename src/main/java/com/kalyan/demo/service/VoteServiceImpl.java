package com.kalyan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.CommentRepository;
import com.kalyan.demo.dao.PostRepository;
import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.entity.Post;
import com.kalyan.demo.entity.User;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public boolean upvotePost(int userId, int postId) {
		if (this.userRepository.existsById(userId) == true) {
			User user = this.userRepository.findById(userId).get();
			if (user.getUpvotedPosts().contains(postRepository.findById(postId).get()) == true) {
				throw new RuntimeException("Post Already Upvoted by user");
			} else if (this.postRepository.existsById(postId)) {
				Post post = this.postRepository.findById(postId).get();

				// if post is downvoted by user, remove the downvote before upvoting it
				if (user.getDownvotedPosts().contains(post) == true) {
					user.getDownvotedPosts().remove(post);
				}
				user.getUpvotedPosts().add(post);
				user.setUpvotedPosts(user.getUpvotedPosts());
				this.userRepository.save(user);
				return true;
			}
		} else {
			throw new RuntimeException("User doesn't exist");
		}
		return false;
	}

	@Override
	public boolean upvoteComment(int userId, int commentId) {
		if (this.userRepository.existsById(userId) == true) {
			User user = this.userRepository.findById(userId).get();
			if (user.getUpvotedComments().contains(commentRepository.findById(commentId).get()) == true) {
				throw new RuntimeException("Comment Already Upvoted by user");
			} else if (this.commentRepository.existsById(commentId)) {
				Comment comment = this.commentRepository.findById(commentId).get();
				if (user.getDownvotedComments().contains(comment) == true) {
					user.getDownvotedComments().remove(comment);
				}
				user.getUpvotedComments().add(comment);
				user.setUpvotedComments(user.getUpvotedComments());
				this.userRepository.save(user);
				return true;
			}
		} else {
			throw new RuntimeException("User doesn't exist");
		}
		return false;
	}

	@Override
	public boolean downvotePost(int userId, int postId) {
		if (this.userRepository.existsById(userId) == true) {
			User user = this.userRepository.findById(userId).get();
			if (user.getDownvotedPosts().contains(postRepository.findById(postId).get()) == true) {
				throw new RuntimeException("Post Already Downvoted by user");
			} else if (this.postRepository.existsById(postId)) {
				Post post = this.postRepository.findById(postId).get();

				// if post is upvoted by user, remove the upvote before upvoting it
				if (user.getUpvotedPosts().contains(post) == true) {
					user.getUpvotedPosts().remove(post);
				}
				user.getDownvotedPosts().add(post);
				user.setDownvotedPosts(user.getDownvotedPosts());
				this.userRepository.save(user);
				return true;
			}
		} else {
			throw new RuntimeException("User doesn't exist");
		}
		return false;
	}

	@Override
	public boolean downvotedComment(int userId, int commentId) {
		if (this.userRepository.existsById(userId) == true) {
			User user = this.userRepository.findById(userId).get();
			if (user.getDownvotedComments().contains(commentRepository.findById(commentId).get()) == true) {
				throw new RuntimeException("Comment Already downvoted by user");
			} else if (this.commentRepository.existsById(commentId)) {
				Comment comment = this.commentRepository.findById(commentId).get();
				if (user.getUpvotedComments().contains(comment) == true) {
					user.getUpvotedComments().remove(comment);
				}
				user.getDownvotedComments().add(comment);
				user.setDownvotedComments(user.getDownvotedComments());
				this.userRepository.save(user);
				return true;
			}
		} else {
			throw new RuntimeException("User doesn't exist");
		}
		return false;
	}

}

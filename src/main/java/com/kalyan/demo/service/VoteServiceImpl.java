package com.kalyan.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.CommentRepository;
import com.kalyan.demo.dao.PostRepository;
import com.kalyan.demo.dao.UserRepository;
import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.entity.Post;

import jakarta.persistence.EntityManager;

@Service
public class VoteServiceImpl implements VoteService {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @Override
    public Post upvotePost(int userId, int postId) {
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
    @Override
    public Post upvoteComment(int userId, int commentId) {
		if (this.userRepository.existsById(id) == true) {
			User user = this.userRepository.findById(id).get();
			if (user.getUpvotedComments().contains(commentRepository.findById(commentId).get()) == true) {
				// return user;
				throw new RuntimeException("Comment Already Upvoted by user");
			} else if (this.postRepository.existsById(commentId)) {
				Comment comment = this.commentRepository.findById(commentId).get();
				user.getUpvotedPosts().add(comment);
				user.setUpvotedComments(user.getUpvotedComments());
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

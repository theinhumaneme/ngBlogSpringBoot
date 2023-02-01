package com.kalyan.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.entity.Post;

public interface VoteService {

	// public List<Post> postsUpvoted(int userId);

    public Post upvotePost(int userId, int postId);
    // public List<Post> postsDownvoted();


}

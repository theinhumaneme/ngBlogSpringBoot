package com.kalyan.demo.service;

public interface VoteService {

    public boolean upvotePost(int userId, int postId);

    public boolean upvoteComment(int userId, int commentId);

    public boolean downvotePost(int userId, int postId);

    public boolean downvotedComment(int userId, int commentId);

}

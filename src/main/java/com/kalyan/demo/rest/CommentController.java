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
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.demo.entity.Comment;
import com.kalyan.demo.service.CommentServiceImpl;

@RestController
@RequestMapping(value = "/api",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    private CommentServiceImpl commentServiceImpl;

    public CommentController(CommentServiceImpl commentServiceImpl) {
        this.commentServiceImpl = commentServiceImpl;

    }

    @GetMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getComments() {
        return this.commentServiceImpl.getComments();

    }

    @GetMapping(value = "/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment getCommentById(@PathVariable int commentId) {
        Comment comment = this.commentServiceImpl.getComment(commentId);
        return comment;
    }

    @PostMapping(value = "/comment/{postId}/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment addComment(@RequestBody Comment comment, @PathVariable(name = "postId") int postId,
            @PathVariable(name = "userId") int userId) {
        if (comment.getId() != null)
            comment.setId(null);
        return this.commentServiceImpl.addComment(comment, postId, userId);
    }

    @PutMapping(value = "/comment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment updateComment(@RequestBody Comment comment) {
        return this.commentServiceImpl.updateComment(comment);
    }

    @DeleteMapping(value = "/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment deleteComment(@PathVariable int commentId) {
        Comment comment = this.commentServiceImpl.deleteComment(commentId);
        return comment;
    }

}

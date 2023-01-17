package com.kalyan.demo.service;

import java.util.List;

import com.kalyan.demo.dao.CommentRepository;
import com.kalyan.demo.entity.Comment;

public interface CommentService {
	
	public List<Comment> getComments();

}

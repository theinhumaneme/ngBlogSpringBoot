package com.kalyan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.demo.dao.CommentRepository;
import com.kalyan.demo.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentRepository commentRepository;
	
	
//	public List<Comment> getComments(CommentRepository commentRepository) {
//		return this.commentRepository.findAll();
//	}

	@Override
	public List<Comment> getComments() {
		return this.commentRepository.findAll();
	}

}

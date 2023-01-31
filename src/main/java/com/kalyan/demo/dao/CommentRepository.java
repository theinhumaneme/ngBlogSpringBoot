package com.kalyan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalyan.demo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}

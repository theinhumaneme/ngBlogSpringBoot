package com.kalyan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalyan.demo.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}

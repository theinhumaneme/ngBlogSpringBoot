package com.kalyan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalyan.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}

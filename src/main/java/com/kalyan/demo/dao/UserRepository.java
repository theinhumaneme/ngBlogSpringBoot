package com.kalyan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalyan.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // public List<Post> f
} 

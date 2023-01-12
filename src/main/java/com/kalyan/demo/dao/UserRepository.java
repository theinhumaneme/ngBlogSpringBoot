package com.kalyan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalyan.demo.entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{

}

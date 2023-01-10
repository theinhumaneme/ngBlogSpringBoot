package com.kalyan.demo.entity;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Post{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="date_edited")
	private Date lastEdited;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="user_id_comment")
	private User user;
	
	@OneToMany(mappedBy="post")
	private List<Comment> comments;
}
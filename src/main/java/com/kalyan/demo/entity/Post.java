package com.kalyan.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



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
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="upvoted_posts",
				joinColumns=@JoinColumn(name="post_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersUpvoted;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="downvoted_posts",
				joinColumns=@JoinColumn(name="post_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersDownvoted;
}
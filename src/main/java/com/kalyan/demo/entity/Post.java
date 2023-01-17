package com.kalyan.demo.entity;

import java.sql.Date;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getUsersUpvoted() {
		return usersUpvoted;
	}

	public void setUsersUpvoted(List<User> usersUpvoted) {
		this.usersUpvoted = usersUpvoted;
	}

	public List<User> getUsersDownvoted() {
		return usersDownvoted;
	}

	public void setUsersDownvoted(List<User> usersDownvoted) {
		this.usersDownvoted = usersDownvoted;
	}

	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="date_edited")
	private Date lastEdited;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="upvoted_posts",
				joinColumns=@JoinColumn(name="post_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersUpvoted;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="downvoted_posts",
				joinColumns=@JoinColumn(name="post_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersDownvoted;
}
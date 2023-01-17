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
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateEdited() {
		return dateEdited;
	}

	public void setDateEdited(Date dateEdited) {
		this.dateEdited = dateEdited;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	@Column(name = "date_edited")
	private Date dateEdited;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="upvoted_comments",
				joinColumns=@JoinColumn(name="comment_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersUpvoted;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="downvoted_comments",
				joinColumns=@JoinColumn(name="comment_id"),
				inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> usersDownvoted;
	
}

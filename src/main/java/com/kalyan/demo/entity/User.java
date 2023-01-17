package com.kalyan.demo.entity;

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
import jakarta.persistence.OneToMany;

@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="username")
	private String username;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getUpvotedComments() {
		return upvotedComments;
	}

	public void setUpvotedComments(List<Comment> upvotedComments) {
		this.upvotedComments = upvotedComments;
	}

	public List<Post> getUpvotedPosts() {
		return upvotedPosts;
	}

	public void setUpvotedPosts(List<Post> upvotedPosts) {
		this.upvotedPosts = upvotedPosts;
	}

	public List<Comment> getDownvotedComments() {
		return downvotedComments;
	}

	public void setDownvotedComments(List<Comment> downvotedComments) {
		this.downvotedComments = downvotedComments;
	}

	public List<Post> getDownvotedPosts() {
		return downvotedPosts;
	}

	public void setDownvotedPosts(List<Post> downvotedPosts) {
		this.downvotedPosts = downvotedPosts;
	}

	@OneToMany(fetch = FetchType.EAGER,mappedBy="user", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="user", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="upvoted_comments",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="comment_id"))
	private List<Comment> upvotedComments;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="upvoted_posts",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="post_id"))
	private List<Post> upvotedPosts;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="downvoted_comments",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="comment_id"))
	private List<Comment> downvotedComments;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="downvoted_posts",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="post_id"))
	private List<Post> downvotedPosts;
	
	
	
}
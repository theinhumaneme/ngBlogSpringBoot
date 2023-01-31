package com.kalyan.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property = "id")
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "username")
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getlast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
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

	// public List<Comment> getUpvotedComments() {
	// return upvotedComments;
	// }

	// public void setUpvotedComments(List<Comment> upvotedComments) {
	// this.upvotedComments = upvotedComments;
	// }

	public List<Post> getUpvotedPosts() {
	return upvotedPosts;
	}

	public void setUpvotedPosts(List<Post> upvotedPosts) {
	this.upvotedPosts = upvotedPosts;
	}

	// public List<Comment> getDownvotedComments() {
	// return downvotedComments;
	// }

	// public void setDownvotedComments(List<Comment> downvotedComments) {
	// this.downvotedComments = downvotedComments;
	// }

	// public List<Post> getDownvotedPosts() {
	// return downvotedPosts;
	// }

	// public void setDownvotedPosts(List<Post> downvotedPosts) {
	// this.downvotedPosts = downvotedPosts;
	// }
	@JsonManagedReference(value = "user-posts")
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
	private List<Post> posts;

	@JsonManagedReference(value = "user-comments")
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
	private List<Comment> comments;

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", posts=" + posts + ", comments=" + comments + "]";
	}

	// @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	// @JoinTable(name="upvoted_comments",
	// joinColumns=@JoinColumn(name="user_id"),
	// inverseJoinColumns=@JoinColumn(name="comment_id"))
	// private List<Comment> upvotedComments;
	@ManyToMany()
	@JoinTable(name="upvoted_posts",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="post_id"))
	private List<Post> upvotedPosts;

	// @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinTable(name="downvoted_comments",
	// joinColumns=@JoinColumn(name="user_id"),
	// inverseJoinColumns=@JoinColumn(name="comment_id"))
	// private List<Comment> downvotedComments;

	// @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinTable(name="downvoted_posts",
	// joinColumns=@JoinColumn(name="user_id"),
	// inverseJoinColumns=@JoinColumn(name="post_id"))
	// private List<Post> downvotedPosts;

}